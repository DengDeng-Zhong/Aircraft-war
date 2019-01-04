package gq.dengbo.shoot;

public class Sky {
    int width;
    int height;
    int x;
    int y;
    int speed;
    int y1;     // 第二张图片的y坐标
    public Sky() {
        width = 400;
        height = 700;
        x = 0; 
        y =0;
        speed = 1; 
        y1 = -700;
    }
    
    public void step(){
        System.out.println("天空的y坐标移动了"+speed);
    }
    
}
