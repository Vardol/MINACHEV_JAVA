import java.util.Random;

public abstract class MapObject implements Positioned {
    protected String name;
    protected String id;
    protected int positionX;
    protected int positionY;
    protected Map map;

    public String generateNewId(String className) {
        String result = (className + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit());
        return result;
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

    public void setPositionX(int positionX) {
        if (positionX > this.map.getSizeX()) {
            throw new IllegalArgumentException();
        }
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        if (positionY > this.map.getSizeY()) {
            throw new IllegalArgumentException();
        }
        this.positionY = positionY;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }
}
