public class Spaceship extends Mechanized implements Flying, Shooting {
	protected static final int SPACESHIPMAXSPEED = 10000;
	public static final int SPACESHIPMAXHEIGHT = 2000;

	public Spaceship() {
		this.size = STANDARTSIZE * 4;
		this.speed = SPACESHIPMAXSPEED;
		this.maxheight = SPACESHIPMAXHEIGHT;
		this.drivemethod = this.engine;
		this.name = "Spaceship";
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

@Override
	public void shoot() {
		System.out.println(this.name + "shoots megablaster.");
		System.out.println("ФЬЮЮЮЮЮЮЮЮЮЮЮЮЮЮЮ ЖЖЖЖ-ТЫЫЫЫЫЫЫЫЫЫЫЩЬ!!!");
	}

}