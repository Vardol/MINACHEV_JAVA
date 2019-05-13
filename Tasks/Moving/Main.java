import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        Map map = new Map(10, 10);

        Person humbleMee = new Person("Me", 1);
        humbleMee.setMap(map, rnd.nextInt(10), rnd.nextInt(10));

        Person sprinter = new Person("Sprinter", 2);
        sprinter.setMap(map, rnd.nextInt(10), rnd.nextInt(10));

        Home home = new Home("Homerun", map.getSizeX() / 2, map.getSizeY() / 2, map);
        if (map.addObject(home)) {
        } else {
            System.err.println("can not add Home");
        }

        humbleMee.setTarget(home);
        sprinter.setTarget(humbleMee);

        map.status();

        //System.out.println(humbleMee.getTarget().getName());
        //System.out.println(sprinter.getTarget().getName());

        //System.out.print(sprinter.getPositionX() + " ");
        //System.out.println(sprinter.getPositionY());
        //System.out.print(humbleMee.getPositionX() + " ");
        //System.out.println(humbleMee.getPositionY());

        //System.out.println(humbleMee.getMap().getSizeX());

        humbleMee.start();
        sprinter.start();

        //while (true) {

        //}
    }
}
