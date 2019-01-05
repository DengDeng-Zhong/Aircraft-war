package gq.dengbo.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class FlyingObject {
    protected int width;
    protected int height;
    protected int x;
    protected int y;

    /**
     * 给大敌机，小敌机，蜜蜂的
     * 
     * @param width
     *            宽
     * @param height
     *            高
     */
    public FlyingObject(int width, int height) {
        this.width = width;
        this.height = height;
        Random random = new Random();
        x = random.nextInt(512 - this.width); // 0到(窗口宽-敌人宽)之间的随机数
        y = -this.height; // 负的敌人的高
    }

    /**
     * 给英雄机，子弹， 天空提供的
     * 
     * @param width
     *            宽
     * @param height
     *            高
     * @param x
     * @param y
     */
    public FlyingObject(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    /**
     * 飞行移动
     */
    public void step() {
        System.out.println("飞行物移动了");
    }
    
    /**
     * 加载图片
     * @param fileName 需要读取的文件路径
     * @return 文件
     */
    public static BufferedImage readImage(String fileName) {
        try {
            BufferedImage image = ImageIO.read(FlyingObject.class.getResource(fileName));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
