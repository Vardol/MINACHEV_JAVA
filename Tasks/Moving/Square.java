import java.util.Random;

public class Square {
    protected MapSubject subjects[];
    protected MapObject objects[];
    protected int objectsCounter;
    protected int subjectsCounter;
    protected static final int MAX_SUBJECTS_PER_SQUARE = 2;
    protected static final int MAX_OBJECTS_PER_SQUARE = 100; // TODO: protected Landscape landscape; protected Feature features;

    public Square() {
        this.subjects = new MapSubject[MAX_SUBJECTS_PER_SQUARE];
        this.objects = new MapObject[MAX_OBJECTS_PER_SQUARE];
        this.objectsCounter = 0;
        this.subjectsCounter = 0;
    }

    public boolean contains(String id) {
        //System.out.println("Contains() in progresss. searching for " + id);
        if (this.subjectsCounter > 0) {
            for (int i = 0; i < this.subjectsCounter; i++) {
                //System.out.println("Searching. Current object has id = " + this.subjects[i].getMapSubjectId());
                if (id.equals(this.subjects[i].getMapSubjectId())) {
                    return true;
                }
            }
        }
        if (this.objectsCounter > 0) {
            for (int i = 0; i < this.objectsCounter; i++) {
                    if (id.equals(this.objects[i].getId())) {
                        return true;
                    }
            }
        }
        //System.out.println("Contains() was called. Returning False. subjectsCounter=" + this.subjectsCounter + "; objectsCounter=" + this.objectsCounter);
        return false;
    }

    public int search(String id) {
        for (int i = 0; i < this.subjects.length; i++) {
            if (this.subjects[i] != null) {
                if (id.equals(this.subjects[i].getMapSubjectId())) {
                    return i;
                }
            }
        }
        for (int i = 0; i < this.objects.length; i++) {
            if (this.objects[i] != null) {
                if (id.equals(this.objects[i].getId())) {
                    return i;
                }
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

    public boolean canAddObject() {
        if (this.objectsCounter < this.objects.length) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addSubject(MapSubject mapSubject) {
        if (this.canAddSubject()) {
            this.subjects[subjectsCounter] = mapSubject;
            this.subjectsCounter++;
            return true;
        } else {
            return false;
        }
    }

    public boolean addObject(MapObject mapObject) {
        if (this.canAddObject()) {
            this.objects[objectsCounter] = mapObject;
            this.objectsCounter++;
            return true;
        } else {
            return false;
        }
    }

    public void removeSubject(String id) {
        if (this.contains(id)) {
            for (int i = this.search(id); i < this.subjectsCounter - 1; i++) {
                this.subjects[i] = this.subjects[i + 1];
            }
            this.subjects[subjectsCounter - 1] = null;
            this.subjectsCounter--;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void removeObject(String id) {
        if (this.contains(id)) {
            for (int i = this.search(id); i < this.objectsCounter - 1; i++) {
                this.objects[i] = this.objects[i + 1];
            }
            this.objects[objectsCounter - 1] = null;
            this.objectsCounter--;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getSubjectsCounter() {
        return this.subjectsCounter;
    }

    public int getObjectsCounter() {
        return this.objectsCounter;
    }

}
