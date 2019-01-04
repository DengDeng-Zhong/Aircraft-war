package gq.dengbo.shoot;

public class World {
    Sky sky;
    Hero hero;
    Airplane a1;
    BigAirplane a2;
    Bee bee;
    Bullet bullet;
    
    
    
    public void action() {
        sky = new Sky();
        hero = new Hero();
        a1 = new Airplane();
        a2= new BigAirplane();
        bee= new Bee();
        bullet = new Bullet();
        System.out.println("天空的宽:"+sky.width+"天空的高:"+sky.height+"天空的X:"+sky.x+"天空的y:"+sky.y+"天空的速度："+sky.speed+"天空的Y1:"+sky.y1);
        System.out.println("英雄机的宽:"+hero.width+"英雄机的高:"+hero.height+"英雄机的X:"+hero.x+"英雄机的y:"+hero.y+"英雄机的生命："+hero.life+"英雄机的火力:"+hero.doubleFire);

    }



    public static void main(String[] args) {
         World world = new World();
         world.action();
    }

}
