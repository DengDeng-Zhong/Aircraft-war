package gq.dengbo.shoot;

import java.util.Random;

public class Bee {
    int width;
    int height;
    int x;
    int y;
    int xSpeed;
    int ySpeed;
    int awardType;  // 奖励类型
    public Bee() {
        width = 60;
        height = 50;
        Random random = new Random();
        x = random.nextInt(400- this.width);
        y = -this.height;
        xSpeed = 1; 
        ySpeed = 2;
        awardType = random.nextInt(2);
    }
    
    public void step(){
        System.out.println("小蜜蜂的x坐标移动了" + xSpeed+"小蜜蜂的y坐标移动了" +ySpeed);
    }
    
}
