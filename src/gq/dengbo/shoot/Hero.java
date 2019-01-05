package gq.dengbo.shoot;

import java.awt.image.BufferedImage;

/**
 * 英雄机
 * 
 * @author DengBo
 *
 */
public class Hero extends FlyingObject {
    private static BufferedImage images;
    
    static{
        images = readImage("hero.png");
    }
    private int life;
    private int doubleFire;

    public Hero() {
        super(97, 124, 140, 400);
        life = 3;
        doubleFire = 0;
    }
    /** 
     * 英雄机随机鼠标移动  x/y:鼠标的x坐标和y坐标
     */
    public void moveTo(int x, int y) {
        System.out.println("英雄机随着鼠标移动了");
    }
    
    /** 
     * 重写step()移动 
     */
    public void step() {
        System.out.println("英雄机切换图片啦!");
    }
    @Override
    public BufferedImage getImage() {
        if (isLife()) {
            return images;
        }
        return null;
    }

}
