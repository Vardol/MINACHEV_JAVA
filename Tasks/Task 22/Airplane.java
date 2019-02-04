import java.util.Random;

public class Airplane extends Mechanized implements Flying {
	protected static final int PLANEMAXSPEED = 1000;
	public static final int PLANE_MAX_HEIGHT = 20;
	private int maxheight;

	public Airplane() {
		this.size = STANDARTSIZE * 4;
		this.speed = PLANEMAXSPEED;
		this.maxheight = PLANE_MAX_HEIGHT;
		this.name = "Airplane";
		this.drivemethod = this.engine;
		Random rnd = new Random();
		this.position = (rnd.nextInt(10001));
		this.platenumber = this.generatePlateNumber();
		this.enginenumber = this.generateEngineNumber();
		this.parked = false;
	}

@Override
	public void move(int distance) {
		this.fly(distance, DEFAULT_HEIGHT);
	}
	
	public int getMaxheight() {
		return this.maxheight;
	}

	public void fly(int distance, int height) {
		if (this.parked) {
			System.out.println("Unpark first.");
			return;
		}
		if (distance > this.speed || (distance * - 1) > this.speed) {
			System.out.println("Too far. Max speed is - " + this.speed);
			return;
		}
		if (height > this.maxheight) {
			System.out.println("Too high. Max height is - " + this.maxheight);
			return;
		}
		if (height <= this.maxheight && distance <= this.speed && (distance * - 1) <= this.speed && this.parked == false) {
			this.position = this.position + distance;
			System.out.println(this.name + " flew a distance of " + distance + " at height " + height + " to position " + this.position);
		}
	}

	public int getDEFAULT_HEIGHT() {
		return this.DEFAULT_HEIGHT;
	}

}