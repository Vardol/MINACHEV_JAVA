public class Truck extends Car implements Cargo {

	public static final int CARGO_CAPACITY = 12;
	private int currentcargo = 0;

	public Truck(Space space) {
		this.currentcargo = 0;
		this.name = "Truck";
		this.drivemethod = this.engine;
		this.size = STANDARTSIZE * 2;
		this.speed = CARMAXSPEED / 2;
		Random rnd = new Random();
		this.position = (rnd.nextInt(10001));
		this.platenumber = this.generatePlateNumber();
		this.enginenumber = this.generateEngineNumber();
		this.parked = false;
	}



}