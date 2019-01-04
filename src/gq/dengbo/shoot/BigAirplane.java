package gq.dengbo.shoot;

import java.util.Random;

public class BigAirplane {
    int width;
    int height;
    int x;
    int y;
    int speed;
    public BigAirplane() {
        width = 69;
        height = 99;
        Random random = new Random();
        x = random.nextInt(400 - this.width);
        y = -this.height;
        speed =2;
    }
    
    public void step(){
        System.out.println("大敌机移动了" + speed);
    }
}
