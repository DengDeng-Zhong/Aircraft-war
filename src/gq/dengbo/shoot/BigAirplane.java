package gq.dengbo.shoot;

import java.awt.image.BufferedImage;

public class BigAirplane extends FlyingObject {
    private static BufferedImage[] images;
    static{
        images= new BufferedImage[5];
        for (int i = 0; i < images.length; i++) {
            images[i]=readImage("bigplane"+i+".png");
        }
    }
    private int speed;

    public BigAirplane() {
        super(69, 99);
        speed = 2;
    }
    
    public void step(){
        System.out.println("大敌机的y坐标向下移动了:"+speed);
    }

    int index = 1;
    @Override
    public BufferedImage getImage() {
        if (isLife()) {
            return images[0];
        }else if (isDead()) {
            BufferedImage image = images[index++];
            if (index == images.length) {
                state = REMOVE;
            }
            return image;
        }
        return null;
    }
}
