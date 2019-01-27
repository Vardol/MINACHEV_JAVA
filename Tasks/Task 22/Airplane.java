public class Airplane extends Mechanized implements Flying {
	protected static final int PLANEMAXSPEED = 1000;
	public static final int PLANE_MAX_HEIGHT = 20;
	private int maxheight;

	public Airplane(Space space) {
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

}