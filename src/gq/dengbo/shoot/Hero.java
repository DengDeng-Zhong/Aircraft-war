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
        super(120, 79, 140, 400);
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
        
    }
    @Override
    public BufferedImage getImage() {
        if (isLife()) {
            return images;
        }
        return null;
    }
    
    public Bullet[] shoot() {
        int xStep = this.width/4; //1/4英雄机的宽
        int yStep = 20;           //固定的20
        if(doubleFire>0) { //双
            Bullet[] bs = new Bullet[2]; //2发子弹
            bs[0] = new Bullet(this.x+1*xStep,this.y-yStep); //x:英雄机的x+1/4英雄机的宽 y:英雄机的y-固定的20
            bs[1] = new Bullet(this.x+3*xStep,this.y-yStep); //x:英雄机的x+3/4英雄机的宽 y:英雄机的y-固定的20
            doubleFire-=2; //发射一次双倍火力，则火力值减2
            return bs;
        }else { //单
            Bullet[] bs = new Bullet[1]; //1发子弹
            bs[0] = new Bullet(this.x+2*xStep,this.y-yStep); //x:英雄机的x+2/4英雄机的宽 y:英雄机的y-固定的20
            return bs;
            
        }
    }

}
