package gq.dengbo.shoot;

import java.awt.image.BufferedImage;

/**
 * 子弹类
 * @author DengBo
 *
 */
public class Bullet extends FlyingObject {
    private static BufferedImage image;
    
    static{
        image = readImage("bullet.png");
    }
    
    private int speed;

    Bullet(int x,int y){
        super(8,14,x,y);
        speed = 3;
    }
    /** 重写step()移动 */
    public void step() {
        System.out.println("子弹的y坐标向上移动了:"+speed);
    }
}
