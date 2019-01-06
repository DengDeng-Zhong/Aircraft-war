package gq.dengbo.shoot;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    /**
     * 启动程序
     */
    public void action() {
        
        //创建监听器对象
        MouseAdapter l = new MouseAdapter(){
            public void mouseMoved(MouseEvent event) {
                int x = event.getX();
                int y = event.getY();
                hero.moveTo(x, y);
            }
        };
        
        this.addMouseListener(l);   // 处理鼠标操作事件
        this.addMouseMotionListener(l);// 处理鼠标滑动事件
        
        Timer timer = new Timer();
        int interval = 15;
        timer.schedule(new TimerTask() {
            
            @Override
            public void run() {
                enterAction();
                shootAction();
                stepAction();
                outOfBoundsAction();
                System.out.println(enemies.length+","+bullets.length);
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
