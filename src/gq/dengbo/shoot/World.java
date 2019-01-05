package gq.dengbo.shoot;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 主窗口
 * @author DengBo
 *
 */
public class World extends JPanel{
    public static final int WIDTH = 512;    // 窗口的宽
    public static final int HEIGHT = 768;   // 窗口的高
    
    Sky sky = new Sky();        //天空对象
    Hero hero = new Hero();     //英雄机对象
    FlyingObject[] enemies = {
            new Airplane(),
            new BigAirplane(),
            new Bee()
    };//敌人(小敌机、大敌机、小蜜蜂)数组
    
    Bullet[] bullets = {
            new Bullet(100, 200)
    };       //子弹数组

    public void action() {
        
    }
    
    /**
     * 重写paint()画对象  g:画笔
     */
    public void paint(Graphics g){
        sky.paintObject(g); // 画天空
        hero.paintObject(g);// 画英雄机
        for (int i = 0; i < enemies.length; i++) {//遍历所有敌人
            enemies[i].paintObject(g);
        }
        
        for (int i = 0; i < bullets.length; i++) {//遍历所有子弹
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
