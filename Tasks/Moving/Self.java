import java.util.Random;

public class Self extends MapObject {
    protected MapSubject host;

    public Self(MapSubject host) {
        this.name = host.getName();
        this.positionX = host.getPositionX();
        this.positionY = host.getPositionY();
        this.map = host.getMap();
        this.id = generateNewId("Self");
        this.host = host;
    }

    @Override
    public int getPositionX() {
        return this.host.getPositionX();
    }

    @Override
    public int getPositionY() {
        return this.host.getPositionY();
    }

    @Override
    public void setPositionX(int positionX) {
        
    }

    @Override
    public void setPositionY(int positionY) {
        
    }

    public String getHostId() {
        return this.host.getMapSubjectId();
    }

    public String getMapSubjectName() {
        return this.host.getMapSubjectId();
    }
}
