package gq.dengbo.shoot;

import java.awt.image.BufferedImage;

public class Sky extends FlyingObject {
    private static BufferedImage image;
    
    static{
        image = readImage("background.jpg");
    }
    
    private int speed;
    private int y1; // 第二张图片的y坐标

    public Sky() {
        super(512, 768, 0, 0);
        speed = 1;
        y1 = -700;
    }
    
    /**
     * 重写step（）方法
     */
    public void step(){
        System.out.println("天空的y坐标和y1坐标向下移动了："+speed);
    }
}
