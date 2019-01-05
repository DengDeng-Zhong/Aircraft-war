package gq.dengbo.shoot;

/**
 * 英雄机
 * 
 * @author DengBo
 *
 */
public class Hero extends FlyingObject {

    int life;
    int doubleFire;

    public Hero() {
        super(97, 124, 140, 400);
        life = 3;
        doubleFire = 0;
    }

    public void moveTo(int x, int y) {
        System.out.println("英雄机随着鼠标移动了");
    }
}
