import java.util.Random;

public class Map {
    protected Square area[][];
    //protected String name;
    //protected String id;
    protected int sizeX;
    protected int sizeY;

    public Map(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.area = new Square[sizeX][sizeY];
        for (int i = 0; i < this.area.length; i++) {
            for (int j = 0; j < this.area[i].length; j++) {
                this.area[i][j] = new Square();
            }
        }
    }

    public boolean contains(String id) {
        for (int i = 0; i < this.area.length; i++) {
            for (int j = 0; j < this.area[i].length; j++) {
                if (id.equals(this.area[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addSubject(MapSubject subject) {
        if (this.area[subject.getPositionX()][subject.getPositionY()].canAddSubject()) {
            this.area[subject.getPositionX()][subject.getPositionY()].addSubject(subject);
            return true;
        } else {
            return false;
        }
    }

    public boolean addObject(MapObject object) {
        if (this.area[object.getPositionX()][object.getPositionY()].canAddObject()) {
            this.area[object.getPositionX()][object.getPositionY()].addObject(object);
            return true;
        } else {
            return false;
        }
    }

    public boolean shiftX(MapSubject subject, int direction) {
        //System.out.println("In ShiftX");
        if (this.area[subject.getPositionX() + direction][subject.getPositionY()].canAddSubject()) {
            this.area[subject.getPositionX() + direction][subject.getPositionY()].addSubject(subject);
            //System.out.println("Removing " + subject.getMapSubjectId() + " from " + subject.getPositionX() + " " + subject.getPositionY());
            this.area[subject.getPositionX()][subject.getPositionY()].removeSubject(subject.getMapSubjectId());
            this.status();
            return true;
        } else {
            return false;
        }
    }

    public boolean shiftY(MapSubject subject, int direction) {
        //System.out.println("In ShiftY");
        if (this.area[subject.getPositionX()][subject.getPositionY() + direction].canAddSubject()) {
            this.area[subject.getPositionX()][subject.getPositionY() + direction].addSubject(subject);
            this.area[subject.getPositionX()][subject.getPositionY()].removeSubject(subject.getMapSubjectId());
            this.status();
            return true;
        } else {
            return false;
        }
    }

    public int getSizeX() {
        return this.sizeX;
    }

    public int getSizeY() {
        return this.sizeY;
    }

    public void status() {
        for (int i = 0; i < this.area.length; i++) {
            for (int j = 0; j < this.area[i].length; j++) {
                if (this.area[i][j].getSubjectsCounter() > 0) {
                    System.out.print("S");
                } else {
                    System.out.print(" ");
                }
                if (this.area[i][j].getObjectsCounter() > 0) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
                System.out.print("; ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
