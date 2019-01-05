package gq.dengbo.shoot;

import java.util.Random;

public class FlyingObject {
    int width;
    int height;
    int x;
    int y;
    /**
     * 给大敌机，小敌机，蜜蜂的
     * @param width 宽
     * @param height 高
     */
    public FlyingObject(int width,int height) {
        this.width = width;
        this.height = height;
        Random random = new Random();
        //0到(窗口宽-敌人宽)之间的随机数
        x = random.nextInt(400-this.width); 
        //负的敌人的高
        y = -this.height;
    }
    
    /**
     * 给英雄机，子弹， 天空提供的
     * @param width 宽
     * @param height 高
     * @param x 
     * @param y
     */
    public FlyingObject(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    
    public void step(){
        System.out.println("飞行物移动了");
    }
}
