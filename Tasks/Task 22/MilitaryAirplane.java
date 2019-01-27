public class MilitaryAirplane extends Airplane implements Shooting {

	public MilitaryAirplane(Space space) {
		this.size = STANDARTSIZE * 2;
		this.speed = PLANEMAXSPEED * 2;
		this.maxheight = PLANE_MAX_HEIGHT;
		this.drivemethod = this.engine;
		this.name = "Military Airplane";
		Random rnd = new Random();
		this.position = (rnd.nextInt(10001));
		this.platenumber = this.generatePlateNumber();
		this.enginenumber = this.generateEngineNumber();
		this.parked = false;
	}

@Override
	public void shoot() {
		System.out.println(this.name + "launches a missile.");
		System.out.println("ЖЫШ ШШШШШШШШШШШШШШШШШШШШШШШШШШшшшшшшшшшшшшшшшшшш... БЫДЫЫЫЫЫЫЫЫЩ!!!!");
	}


}