public class Tank extends Mechanized implements Shooting {
	protected static final int TANKSIZE = 2;
	protected static final int TANKMAXSPEED = 200;

	public Tank(Space space) {
		this.size = STANDARTSIZE;
		this.speed = TANKMAXSPEED;
		this.drivemethod = this.engine;
		this.name = "Tank";
		Random rnd = new Random();
		this.position = (rnd.nextInt(10001));
		this.platenumber = this.generatePlateNumber();
		this.enginenumber = this.generateEngineNumber();
		this.parked = false;
	}

@Override
	public void shoot() {
		System.out.println(this.name + "shoots main caliber.");
		System.out.println("БЫДЫЩ!");
	}
}