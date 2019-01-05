package gq.dengbo.shoot;

import java.awt.image.BufferedImage;

/**
 * 小敌机类
 * 
 * @author DengBo
 *
 */
public class Airplane extends FlyingObject {
    /*
     * images图片属性设计为静态变量:
     * 1)Airplane a1 = new Airplane();
     *   1.1)加载Airplane.class到方法区，images到方法区
     *   1.2)执行静态块读取图片
     * 2)Airplane a2 = new Airplane();
     *   2.1)无
     * 3)Airplane a3 = new Airplane();
     *   3.1)无
     */
    /*
     * images图片属性设计为实例变量:
     * 1)Airplane a1 = new Airplane();
     *   1.1)将图片images分配到堆中
     *   1.2)在构造方法中读取图片到images中
     * 2)Airplane a2 = new Airplane();
     *   2.1)将图片images分配到堆中
     *   2.2)在构造方法中读取图片到images中
     * 3)Airplane a3 = new Airplane();
     *   3.1)将图片images分配到堆中
     *   3.2)在构造方法中读取图片到images中
     */
    private static BufferedImage [] images;
    
    static{
        images = new BufferedImage[5];
        for (int i = 0; i < images.length; i++) {
            images[i] = readImage("airplane"+i+".png");
        }
    }
    
    private int speed;

    public Airplane() {
        super(49, 36);
        speed = 2;
    }
    /**
     * 重写step()方法
     */
    public void step(){
        System.out.println("小敌机的y坐标 向下移动了"+speed);
    }
}
