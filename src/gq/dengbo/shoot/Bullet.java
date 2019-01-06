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
        super(96,96,x,y);
        speed = 3;
    }
    /** 重写step()移动 */
    public void step() {
        y -= speed; //向上移动
    }
    
    public BufferedImage getImage(){
        if (isLife()) {         //若活着的
            return image;       //则返回image
        }else if (isDead()) {   //若死了的
            state = REMOVE;     //则状态修改为REMOVE
        }
        return null;            //DEAD和REMOVE时，返回null
    }
    
    /** 重写outOfBounds()越界检测 */
    public boolean outOfBounds(){
        return this.y <= - this.height;//子弹的y<=负的子弹的高，即为越界了
    }
}
