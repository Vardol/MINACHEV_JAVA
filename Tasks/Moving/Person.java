import java.util.Random;

public class Person extends Creature {

    public Person(String name, int speed) {
        this.name = name;
        this.positionX = 0;
        this.positionY = 0;
        //this.targetPositionX = positionX;
        //this.targetPositionY = positionY;
        this.speed = speed;
        this.map = null;
        this.self = new Self(this);
        this.target = this.self;
        this.id = this.generateNewId("Person");
        //if (!this.map.addSubject(this)) {
            //throw new IllegalArgumentException;
        //}
        //System.out.println(this.getMapSubjectName() + " was created in position X - " + this.getPositionX());
        //System.out.println(this.getMapSubjectName() + " was created in position Y - " + this.getPositionY());
    }

    public Person(String name, int speed, String id) {
        this.name = name;
        this.positionX = 0;
        this.positionY = 0;
        //this.targetPositionX = positionX;
        //this.targetPositionY = positionY;
        this.target = this.self;
        this.speed = speed;
        this.map = null;
        this.self = new Self(this);
        this.id = id;
    }

    @Override
    public void run() {
        //System.out.println(this.getMapSubjectName() + " started in position X - " + this.getPositionX());
        //System.out.println(this.getMapSubjectName() + " started in position Y - " + this.getPositionY());
        //System.out.println(this.getMapSubjectName() + " has target position X - " + this.getTarget().getPositionX());
        //System.out.println(this.getMapSubjectName() + " has target position Y - " + this.getTarget().getPositionY());
        //int i = 0;
        while (true) {
            this.moveTo();
            //i++;
            //System.out.println(this.getMapSubjectName() + " i = " + i);
        }
    }
}
