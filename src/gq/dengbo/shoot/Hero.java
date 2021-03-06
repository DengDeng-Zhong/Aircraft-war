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
//        images = new BufferedImage[2];
        images = readImage("hero0.png");
//        images[1] = readImage("hero1.png");
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
        this.x = x- this.width/2;
        this.y = y- this.height/2;
    }
    
    /** 
     * 重写step()移动 
     */
    public void step() {
        
    }
    
    int index =0;
    @Override
    public BufferedImage getImage() {
        if (isLife()) {
            return images;
            //return images[index++%images.length];
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
    /** 英雄机增命 */
    public void addLife(){
        life++;
    }
    /** 获取英雄机的命 */
    public int getLife() {
        return life; //返回命数
    }
    
    /**
     * 英雄机减命
     */
    public void subtractLife() {
        life--;
    }
    
    /** 英雄机增火力 */
    public void addDoubleFire() {
        doubleFire+=40; //火力值增40
    }
    /** 清空英雄机火力值 */
    public void clearDoubleFire() {
        doubleFire  =0;
    }
}
