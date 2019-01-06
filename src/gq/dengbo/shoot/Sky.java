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
        y += speed;
        y1 += speed;
        if (y>= World.HEIGHT) {//若y>=窗口的高，意味着y出去了
            y = -World.HEIGHT;//则修改y为负的窗口的高(挪最上面去)
        }
        if (y1>=World.HEIGHT) {//若y1>=窗口的高，意味着y1出去了
            y1 = -World.HEIGHT;//则修改y1为负的窗口的高(挪最上面去)
        }
    }
    @Override
    public BufferedImage getImage() {
        return image;
    }
    
    public void paintObject(Graphics g){
        g.drawImage(getImage(), this.x, this.y, null);
        g.drawImage(getImage(), x, y1, null);
    }
}
