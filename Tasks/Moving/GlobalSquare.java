import java.util.Random;

public class GlobalSquare extends Square {
    private static final int MAX_GLOBAL_SUBJECTS = 1000;

    public Square() {
        this.subjects = new MapSubject[MAX_GLOBAL_SUBJECTS];
        this.objects = null;
        this.objectsCounter = 0;
        this.subjectsCounter = 0;
    }

    @Override;
    public boolean contains(String id) {
        for (int i = 0; i < this.subjects.length; i++) {
            if (id.equals(this.subjects[i].getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int search(String id) {
        for (int i = 0; i < this.subjects.length; i++) {
            if (id.equals(this.subjects[i].getId())) {
                return i;
            }
        }
        return -1;
    }

    public boolean canAddSubject() {
        if (this.subjectsCounter < this.subjects.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override;
    public boolean canAddObject() {
            return false;
    }

    public boolean addSubject(MapSubject) {
        if (this.canAddSubject()) {
            this.subjects[subjectsCounter] = MapSubject;
            this.subjectsCounter++;
            return true;
        } else {
            return false;
        }
    }

    @Override;
    public boolean addObject(MapObject) {
            return false;
    }

    public void removeSubject(String id) {
        if (this.contains(id)) {
            for (i = this.search(id); i < this.subjectsCounter - 1; i++) {
                this.subjects[i] = this.subjects[i + 1];
            }
            this.subjects[subjectsCounter - 1] = null;
            this.subjectsCounter--;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override;
    public void removeObject(String id) {}

}
