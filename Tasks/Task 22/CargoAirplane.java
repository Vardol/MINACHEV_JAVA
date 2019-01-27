public class CargoAirplane extends Airplane implements Cargo {

	public static final int CARGO_CAPACITY = 12;
	private int currentcargo = 0;

	public CargoAirplane(Space space) {
		this.currentcargo = 0;
		this.size = STANDARTSIZE * 4;
		this.speed = PLANEMAXSPEED / 2;
		this.maxheight = PLANE_MAX_HEIGHT;
		this.drivemethod = this.engine;
		this.name = "Cargo Airplane";
		Random rnd = new Random();
		this.position = (rnd.nextInt(10001));
		this.platenumber = this.generatePlateNumber();
		this.enginenumber = this.generateEngineNumber();
		this.parked = false;
	}
}