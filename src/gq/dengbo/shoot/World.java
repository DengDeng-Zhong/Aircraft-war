package gq.dengbo.shoot;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 主窗口
 * @author DengBo
 *
 */
public class World extends JPanel{
    Sky sky = new Sky();        //天空对象
    Hero hero = new Hero();     //英雄机对象
    FlyingObject[] enemies = {};//敌人(小敌机、大敌机、小蜜蜂)数组
    Bullet[] bullets = {};       //子弹数组

    public void action() {
        enemies = new FlyingObject[5];
        enemies[0] = new Airplane();    //向上造型
        enemies[1] = new Airplane();
        enemies[2] = new BigAirplane();
        enemies[3] = new BigAirplane();
        enemies[4] = new Bee();
        for (int i = 0; i < enemies.length; i++) {
            System.out.println(enemies[i].x + "," + enemies[i].y);
            enemies[i].step();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(512, 768);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
        
        world.action();
    }

}
