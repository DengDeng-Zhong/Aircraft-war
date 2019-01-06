package gq.dengbo.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public abstract class FlyingObject {
    public static final int LIFE = 0; // 活着的
    public static final int DEAD = 1; // 死了的
    public static final int REMOVE = 2; // 删除的
    protected int state = LIFE; // 当前状态（默认是活着的）

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
     * 飞行物移动
     */
    public abstract void step();

    /**
     * 加载图片
     * 
     * @param fileName
     *            需要读取的文件路径
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

    /**
     * 获取图片
     * 
     * @return 图片
     */
    public abstract BufferedImage getImage();

    /**
     * 判断是否是活着的
     * 
     * @return 状态
     */
    public boolean isLife() {
        return state == LIFE; // 当前状态为LIFE，表示对象为活着的
    }

    /**
     * 判断是否是删除的
     * 
     * @return 状态
     */
    public boolean isDead() {
        return state == DEAD; // 当前状态为DEAD，表示对象为死了的
    }

    /**
     * 判断是否是删除的
     * 
     * @return 状态
     */
    public boolean isRemove() {
        return state == REMOVE; // 当前状态为REMOVE，表示对象为删除的
    }

    /**
     * 画图片
     * 
     * @param g
     *            画笔
     */
    public void paintObject(Graphics g) {
        g.drawImage(this.getImage(), this.x, this.y, null);
    }
    
    /**  敌人的越界检查 */
    public boolean outOfBounds() {
        return this.y >= World.HEIGHT; // 敌人的y》=窗口的高，即为越界了
    }
}
