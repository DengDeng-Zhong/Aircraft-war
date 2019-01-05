package gq.dengbo.shoot;

import java.util.Random;

public class Bee extends FlyingObject {

    int xSpeed;
    int ySpeed;
    int awardType; // 奖励类型

    public Bee() {
        super(60, 50);
        xSpeed = 1;
        ySpeed = 2;
        Random random = new Random();
        awardType = random.nextInt(2);
    }

}
