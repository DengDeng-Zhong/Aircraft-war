package gq.dengbo.shoot;

import java.util.Random;

/**
 * 小敌机类
 * 
 * @author DengBo
 *
 */
public class Airplane {
    int width;
    int heigth;
    int x;
    int y;
    int speed;

    public Airplane() {
        width = 49;
        heigth = 36;
        Random random = new Random();
        x = random.nextInt(400-this.width);
        y = -this.heigth;
        speed = 2;
    }

    public void Step() {
        System.out.println("小敌机移动了");
    }
}
