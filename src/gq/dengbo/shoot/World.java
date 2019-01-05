package gq.dengbo.shoot;

public class World {
    Sky sky;
    Hero hero;
    Airplane[] as;
    BigAirplane[] bas;
    Bee[] bees;
    Bullet[] bullets;

    public void action() {

        as = new Airplane[3];
        as[0] = new Airplane();
        as[1] = new Airplane();
        as[2] = new Airplane();
        for (int i = 0; i < as.length; i++) {
            Airplane airplane = as[i];
            System.out.println(airplane.x + "," + airplane.y);
            airplane.step();
        }
    }

    public static void main(String[] args) {
        World world = new World();
        world.action();
    }

}
