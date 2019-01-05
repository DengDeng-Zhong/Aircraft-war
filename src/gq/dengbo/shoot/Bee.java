package gq.dengbo.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Bee extends FlyingObject {
    private static BufferedImage [] images;
    
    static{
        images =new BufferedImage[5];
        for (int i = 0; i < images.length; i++) {
            images[i] = readImage("bee"+i+".png");
        }
    }
    
    private int xSpeed; // x坐标移动速度
    private int ySpeed; // x坐标移动速度
    private int awardType; // 奖励类型

    public Bee() {
        super(60, 50);
        xSpeed = 1;
        ySpeed = 2;
        Random random = new Random();
        awardType = random.nextInt(2);
    }

    /**
     * 重写step（）方法
     */
    public void step() {
        System.out.println("小蜜蜂的x坐标向左移动了："+xSpeed+",y"
                + "坐标向下移动了："+ySpeed);
    }
    int index = 1;//下标
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
