package gq.dengbo.shoot;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 主窗口
 * 
 * @author DengBo
 *
 */
public class World extends JPanel {
    public static final int WIDTH = 512; // 窗口的宽
    public static final int HEIGHT = 768; // 窗口的高
    
    public static final int START= 0;
    public static final int RUNNING = 1;
    public static final int PAUSE = 2;
    public static final int GAME_OVER =3;
    private int state = START;
    
    private static BufferedImage start;
    private static BufferedImage pause;
    private static BufferedImage gameover;
    static{
        start = FlyingObject.readImage("start.png");
        pause = FlyingObject.readImage("pause.png");
        gameover = FlyingObject.readImage("gameover.png");
    }
    
    private Sky sky = new Sky(); // 天空对象
    private Hero hero = new Hero(); // 英雄机对象
    private FlyingObject[] enemies = {};// 敌人(小敌机、大敌机、小蜜蜂)数组
    private Bullet[] bullets = {}; // 子弹数组

    /**
     * 随机生成敌人
     * 
     * @return 返回敌人对象
     */
    public FlyingObject nextOne() {
        Random random = new Random();
        int type = random.nextInt(20);
        if (type < 5) {
            return new Bee();
        } else if (type < 12) {
            return new Airplane();
        } else {
            return new BigAirplane();
        }
    }

    int enterIndex = 0; // 敌人入场计数

    /**
     * 敌人入场（蜜蜂，大小敌机）
     */
    public void enterAction() { // 每10毫秒走一次
        enterIndex++;// 每10毫秒增1
        if (enterIndex % 40 == 0) {// 每400(10*40)毫秒走一次
            FlyingObject object = nextOne();// 获取敌人对象
            enemies = Arrays.copyOf(enemies, enemies.length + 1);// 扩容
            enemies[enemies.length - 1] = object;// 将敌人对象添加到最后一个元素上
        }
    }

    int shootIndex = 0; // 射击次数

    /**
     * 子弹入场
     */
    public void shootAction() {
        shootIndex++;
        if (shootIndex % 30 == 0) {
            Bullet[] bs = hero.shoot();// 获取子弹对象
            bullets = Arrays.copyOf(bullets, bullets.length + bs.length);// 扩容(bs有几个元素就扩大几个容量)
            System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length); // 数组的追加

        }
    }

    /**
     * 飞行物移动
     */
    public void stepAction() {
        sky.step();
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].step();
        }
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].step();
        }
    }

    /**
     * 删除越界的敌人和子弹
     */
    public void outOfBoundsAction() {
        int index = 0;// 1)不越界敌人数组下标 2)不越界敌人个数
        FlyingObject[] enemyLives = new FlyingObject[enemies.length];// 不越界敌人数组
        for (int i = 0; i < enemies.length; i++) {// 遍历敌人数组
            FlyingObject flyingObject = enemies[i];// 获取每一个敌人
            if (!flyingObject.outOfBounds()) {// 不越界
                enemyLives[index] = flyingObject;// 将不越界敌人装到不越界敌人数组中
                index++;// 1)不越界敌人数组下标增一 2)不越界敌人个数增一
            }
        }

        enemies = Arrays.copyOf(enemyLives, index);// 将不越界敌人数组复制到enemies中，index为几则enemies的长度为几

        index = 0;
        // 1)下标归零 //2)个数归零
        Bullet[] bulletLives = new Bullet[bullets.length];
        for (int i = 0; i < bullets.length; i++) {
            Bullet b = bullets[i];
            if (!b.outOfBounds()) {
                bulletLives[index] = b;
                index++;
            }
        }
        bullets = Arrays.copyOf(bulletLives, index);
    }
    
    int score = 0; //得分
    
    /**
     * 子弹与敌人的碰撞
     */
    public void bulletBangAction() { //每10毫秒走一次
        for(int i=0;i<bullets.length;i++) { //遍历所有子弹
            Bullet b = bullets[i]; //获取每一个子弹
            for(int j=0;j<enemies.length;j++) { //遍历所有敌人
                FlyingObject f = enemies[j]; //获取每一个敌人
                if(b.isLife() && f.isLife() && f.hit(b)) { //若都活着并且撞上了
                    b.goDead(); //子弹去死
                    f.goDead(); //敌人去死
                    
                    if(f instanceof Enemy) { //若被撞对象能得分
                        Enemy e = (Enemy)f;  //将被撞对象强转为得分接口
                        score += e.getScore(); //玩家得分
                    }
                    if(f instanceof Award) { //若被撞对象为奖励
                        Award a = (Award)f;  //将被撞对象强转为奖励接口
                        int type = a.getAwardType(); //获取奖励类型
                        switch(type) { //根据奖励类型来获取不同的奖励
                        case Award.DOUBLE_FIRE:   //若奖励类型为火力值
                            hero.addDoubleFire(); //则英雄机增火力
                            break;
                        case Award.LIFE:    //若奖励类型为命
                            hero.addLife(); //则英雄机增命
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public void heroBangAction(){
        for (int i = 0; i < enemies.length; i++) {
            FlyingObject flyingObject = enemies[i];
            if (hero.isLife() && flyingObject.isLife() && flyingObject.hit(hero)) {
                flyingObject.goDead();
                hero.subtractLife();
                hero.clearDoubleFire();
            }
        }
    }
    
    public void checkGameOverAction() {
        if (hero.getLife() <= 0) {
            state = GAME_OVER;
        }
    }
    
    /**
     * 启动程序
     */
    public void action() {
        
        //创建监听器对象
        MouseAdapter l = new MouseAdapter(){
            /** 重写鼠标移动事件 */
            public void mouseMoved(MouseEvent event) {
                int x = event.getX();
                int y = event.getY();
                hero.moveTo(x, y);
            }
            /** 重写鼠标点击事件 */
            public void mouseClicked(MouseEvent e) {
                switch(state) { //根据当前状态做不同的处理
                case START:        //启动状态时
                    state=RUNNING; //修改为运行状态
                    break;
                case GAME_OVER: //游戏结束状态时
                    score = 0;  //清理现场
                    sky = new Sky();
                    hero = new Hero();
                    enemies = new FlyingObject[0];
                    bullets = new Bullet[0];
                    state=START; //修改为启动状态
                    break;
                }
            }
            
            /** 重写鼠标移出事件 */
            public void mouseExited(MouseEvent e) {
                if(state==RUNNING) { //运行状态时
                    state=PAUSE;     //修改为暂停状态
                }
            }
            /** 重写鼠标移入事件 */
            public void mouseEntered(MouseEvent e) {
                if(state==PAUSE) { //暂停状态时
                    state=RUNNING; //修改为运行状态
                }
            }
            
        };
        
        this.addMouseListener(l);   // 处理鼠标操作事件
        this.addMouseMotionListener(l);// 处理鼠标滑动事件
        
        Timer timer = new Timer();
        int interval = 10;
        timer.schedule(new TimerTask() {
            
            @Override
            public void run() {
                if (state == RUNNING) {
                    enterAction();
                    shootAction();
                    stepAction();
                    outOfBoundsAction();
                    bulletBangAction();
                    heroBangAction();
                    System.out.println(enemies.length+","+bullets.length);
                    checkGameOverAction();
                    
                }
                repaint();
            }
        },interval,interval);
    }

    /**
     * 重写paint()画对象 g:画笔
     */
    public void paint(Graphics g) {
        sky.paintObject(g); // 画天空
        hero.paintObject(g);// 画英雄机
        for (int i = 0; i < enemies.length; i++) {// 遍历所有敌人
            enemies[i].paintObject(g);
        }

        for (int i = 0; i < bullets.length; i++) {// 遍历所有子弹
            bullets[i].paintObject(g);
        }
        
        g.drawString("SCORE"+score, 10, 25);//画分
        g.drawString("LIFE:"+hero.getLife(), 10, 45);
        g.drawString("版本号：V0.09", 10, 65);
    
        switch(state) { //根据当前状态画不同的图
        case START: //启动状态时画启动图
            g.drawImage(start,0,0,null);
            break;
        case PAUSE: //暂停状态时画暂停图
            g.drawImage(pause,0,0,null);
            break;
        case GAME_OVER: //游戏结束状态时画游戏结束图
            g.drawImage(gameover,0,0,null);
            break;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        world.action();
    }

}
