public class Bicycle extends Transport {
	protected static final int BICYCLEMAXSPEED = 30;

	public Bicycle() {
		this.size = STANDARTSIZE / 2;
		this.speed = BICYCLEMAXSPEED;
		this.name = "Bicycle";
		this.drivemethod = "Pedals spinning... ";
		Random rnd = new Random();
		this.position = (rnd.nextInt(10001));
		this.platenumber = this.generatePlateNumber();
		this.parked = false;
	}

	public Bicycle(String platenumber) {
		this.size = STANDARTSIZE / 2;
		this.speed = BICYCLEMAXSPEED;
		this.name = "Bicycle";
		this.drivemethod = "Pedals spinning... ";
		Random rnd = new Random();
		this.position = (rnd.nextInt(10001));
		this.platenumber = platenumber;
		this.parked = false;
	}

	public Bicycle(int position) {
		this.size = STANDARTSIZE / 2;
		this.speed = BICYCLEMAXSPEED;
		this.name = "Bicycle";
		this.drivemethod = "Pedals spinning... ";
		Random rnd = new Random();
		this.position = position;
		this.platenumber = this.generatePlateNumber();
		this.parked = false;
	}

	public Bicycle(int position, String platenumber) {
		this.size = STANDARTSIZE / 2;
		this.speed = BICYCLEMAXSPEED;
		this.name = "Bicycle";
		this.drivemethod = "Pedals spinning... ";
		Random rnd = new Random();
		this.position = position;
		this.platenumber = platenumber;
		this.parked = false;
	}

}