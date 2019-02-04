import java.util.Random;

public class CargoAirplane extends Airplane implements Cargo {

	public static final int CARGO_CAPACITY = 50;
	private int currentcargo = 0;

	public CargoAirplane() {
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

	public void load(int cargo) {
		if (cargo > this.getAvailableCargo()) {
			System.out.println("Too heavy load. Cant load that much. Only have" + (this.CARGO_CAPACITY - this.currentcargo) + "empty space left");
		} else {
			this.currentcargo = this.currentcargo + cargo;
		}
	}

	public void unload(int cargo) {
		if (cargo > this.currentcargo) {
			System.out.println("Dont have that much cargo. Only have" + this.currentcargo);
		} else {
			this.currentcargo = this.currentcargo - cargo;
		}
	}

	public int getAvailableCargo() {
		return (this.CARGO_CAPACITY - this.currentcargo);
	}

	public int getCurrentCargo() {
		return this.currentcargo;
	}

}