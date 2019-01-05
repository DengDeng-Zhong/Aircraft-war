package gq.dengbo.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sky extends FlyingObject {
    private static BufferedImage image;
    
    static{
        image = readImage("background.png");
    }
    
    private int speed;
    private int y1; // 第二张图片的y坐标

    public Sky() {
        super(World.WIDTH, World.HEIGHT, 0, 0);
        speed = 1;
        y1 = -World.HEIGHT;
    }
    
    /**
     * 重写step（）方法
     */
    public void step(){
        System.out.println("天空的y坐标和y1坐标向下移动了："+speed);
    }
    @Override
    public BufferedImage getImage() {
        // TODO Auto-generated method stub
        return image;
    }
    
    public void paintObject(Graphics g){
        g.drawImage(getImage(), this.x, this.y, null);
        g.drawImage(getImage(), x, y1, null);
    }
}
