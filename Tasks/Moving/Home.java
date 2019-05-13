import java.util.Random;

public class Home extends MapObject {


    public Home(String name, int positionX, int positionY, Map map) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.map = map;
        this.id = this.generateNewId("Home");
    }
}
