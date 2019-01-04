package gq.dengbo.shoot;
/**
 * 子弹类
 * @author DengBo
 *
 */
public class Bullet {
    int width;
    int height;
    int x;
    int y;
    int speed;
    public Bullet() {
        width = 8;
        height = 14;
        this.x = x;
        this.y = y;
        speed = 3;
    }
    
    public void Step(){
        System.out.println("子弹y坐标移动了，"+speed);
    }
    
}
