public class Glider extends Mechanized implements Flying {
	protected static final int GLIDERMAXSPEED = 100;
	public static final int GLIDER_MAX_HEIGHT = 3;
	private int maxheight;

	public Glider(Space space) {
		this.size = STANDARTSIZE / 2;
		this.speed = PLANEMAXSPEED;
		this.maxheight = PLANE_MAX_HEIGHT;
		this.name = "Glider";
		this.drivemethod = "Wind pulls the wing! ";
		Random rnd = new Random();
		this.position = (rnd.nextInt(10001));
		this.platenumber = this.generatePlateNumber();
		this.parked = false;
	}

@Override
	public void move(int distance) {
		this.fly(distance, this.maxheight);
	}
	
	public int getMaxheight() {
		return this.maxheight;
	}

}