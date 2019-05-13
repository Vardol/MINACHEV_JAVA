import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class MapSubject extends Thread implements Positioned {
    protected String name;
    protected String id;
    protected int positionX;
    protected int positionY;
    protected Map map;
    protected Self self;
    protected static final Lock lock = new ReentrantLock();

    public String generateNewId(String className) {
        String result = (className + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit());
        return result;
    }

    public void setMap(Map map, int positionX, int positionY) {
        //System.out.println(this.getMapSubjectName() + " is entering map from position x - " + this.getPositionX() + ". It will be changed to " + positionX);
        //System.out.println(this.getMapSubjectName() + " is entering map from position y - " + this.getPositionY() + ". It will be changed to " + positionY);
        if (positionX <= map.getSizeX() - 1 && positionY <= map.getSizeY() - 1) {
            this.map = map;
            this.positionX = positionX;
            this.positionY = positionY;
            //System.out.println(this.getMapSubjectName() + " position x is now - " + this.getPositionX());
            //System.out.println(this.getMapSubjectName() + " position y is now - " + this.getPositionY());
            if (!map.addSubject(this)) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Map getMap() {
        return this.map;
    }

    protected char generateLetter() {
        Random rnd = new Random();
        return (char)(rnd.nextInt(26) + 65);
    }

    protected char generateDigit() {
        Random rnd = new Random();
        return (char)(rnd.nextInt(10) + 48);
    }

    @Override
    public int getPositionX() {
        return this.positionX;
    }

    @Override
    public int getPositionY() {
        return this.positionY;
    }

    public String getMapSubjectName() {
        return this.name;
    }

    public String getMapSubjectId() {
        return this.id;
    }

    public MapObject getSelf() {
        return this.self;
    }
}
