import java.util.Random;

public class Car extends Mechanized {
	protected static final int CARMAXSPEED = 200;

	public Car() {
		this.size = STANDARTSIZE;
		this.speed = CARMAXSPEED;
		this.drivemethod = this.engine;
		this.name = "Car";
		Random rnd = new Random();
		this.position = (rnd.nextInt(10001));
		this.platenumber = this.generatePlateNumber();
		this.enginenumber = this.generateEngineNumber();
		this.parked = false;
	}


}