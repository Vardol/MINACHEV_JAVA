public class Bicycle extends Transport {
	protected static final int BICYCLEMAXSPEED = 30;

	public Bicycle(Space space) {
		this.size = STANDARTSIZE / 2;
		this.speed = BICYCLEMAXSPEED;
		this.name = "Bicycle";
		this.drivemethod = "Pedals spinning... ";
		Random rnd = new Random();
		this.position = (rnd.nextInt(10001));
		this.platenumber = this.generatePlateNumber();
		this.parked = false;
	}


}