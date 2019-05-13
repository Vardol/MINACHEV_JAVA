import java.util.Random;
import java.lang.Math;

public abstract class Creature extends MapSubject implements Move {
    protected int speed; //movement speed squares per second
    //protected int targetPositionX;
    //protected int targetPositionY;
    protected MapObject target;

    @Override
    public void moveX(int targetPositionX) {
        try {
            this.sleep(1000 / this.speed);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        if (this.positionX - targetPositionX > 0) {
            this.lock.lock();
            if (this.map.shiftX(this, -1)) {
                this.positionX--;
            } else {
                throw new IllegalArgumentException();
            }
            this.lock.unlock();
        } else {
            this.lock.lock();
            if (map.shiftX(this, 1)) {
                this.positionX++;
            } else {
                throw new IllegalArgumentException();
            }
            this.lock.unlock();
        }
    }

    @Override
    public void moveY(int targetPositionY) {
        try {
            this.sleep(1000 / this.speed);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        if (this.positionY - targetPositionY > 0) {
            this.lock.lock();
            if (this.map.shiftY(this, -1)) {
                this.positionY--;
            } else {
                throw new IllegalArgumentException();
            }
            this.lock.unlock();
        } else {
            this.lock.lock();
            if (this.map.shiftY(this, 1)) {
                this.positionY++;
            } else {
                throw new IllegalArgumentException();
            }
            this.lock.unlock();
        }
    }

    public void moveTo() {
        while (this.positionX != this.target.getPositionX() || this.positionY != this.target.getPositionY()) {
            try {
                this.sleep(1000 / speed);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            if (Math.abs(this.positionX - this.target.getPositionX()) > Math.abs(this.positionY - this.target.getPositionY())) {
                this.moveX(target.getPositionX());
            } else {
                this.moveY(target.getPositionY());
            }
        }
    }

    //public int getTargetPositionX() {
    //    return this.targetPositionX();
    //}

    //public int getTargetPositionY() {
    //    return this.targetPositionY();
    //}

    public MapObject getTarget() {
        return this.target;
    }

    public void setTarget(MapObject target) {
        this.target = target;
    }

    public void setTarget(MapSubject target) {
        this.target = target.getSelf();
    }

    //protected boolean targetWithinReach() {
        //if (this.positionX != this.target.getPositionX() || this.positionY != this.target.getPositionY())
    //}

    public int getSpeed() {
        return this.speed;
    }
}
