package gq.dengbo.shoot;
/**
 * 英雄机
 * @author DengBo
 *
 */
public class Hero {
    int width;
    int height;
    int x;
    int y;
    int life;
    int doubleFire;
    public Hero() {
        width = 97;
        height = 124;
        x = 140;
        y = 400;
        life = 3;
        doubleFire = 0;
    }
    
    public void moveTo(int x, int y){
        System.out.println("英雄机随着鼠标移动了");
    }
    
    public void step(){
        System.out.println("英雄机移动了");
    }
}
