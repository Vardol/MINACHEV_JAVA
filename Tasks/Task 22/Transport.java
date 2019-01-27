import java.util.Random;

public abstract class Transport {
	private String platenumber;
	private int size;
	private int position;
	private int speed;
	private String name;
	private String drivemethod;
	private boolean parked;
	protected static final int STANDARTSIZE = 2;

	public void park(Parking parking) {
		if (this.parked == true || this.position == parking.getPosition()) {
			System.out.println("Already parked");
			this.parked = true
			return;
		}
		if (Math.sqrt(Math.square(this.position - parking.getPosition())) > this.speed) {
			System.out.println("Parking too far. Move closer first.");
			return;
		}
		if (this.size > parking.getAvailableSpace()) {
			System.out.println("Not enough space on the parking.");
			return;
		}
		if (this.size <= parking.getAvailableSpace() && Math.sqrt(Math.square(this.position - parking.getPosition())) <= this.speed && this.parked == false) {
				parking.park(this.getPlateNumber(), this.getSize());
				position = parking.getPosition();
				this.parked = true;
		}
	}

	public void unpark(Parking parking) {
		if (this.parked) {
			parking.unpark(this.getPlateNumber());
			this.position = parking.getPosition() + 1;
			this.parked = false;
		} else {
			System.out.println("Vehicle not parked.");
		}
	}

	protected String generatePlateNumber() {
		String result = (generateLetter() + "" + generateDigit() + "" + generateDigit() + "" + generateDigit() + "" + generateLetter() + "" + generateLetter());
		return result;
	}

	protected char generateLetter() {
		Random rnd = new Random();
		return (rnd.nextInt(26) + 65);
	}

	protected char generateDigit() {
		Random rnd = new Random();
		return (rnd.nextInt(10) + 48);
	}

	public String getPlateNumber() {
		return this.platenumber;
	}

	public int getSize() {
		return this.size;
	}

	public int getPosition() {
		return this.position;
	}

	public int getSpeed() {
		return this.speed;
	}

	public String getName() {
		return this.name;
	}

	public String getEngineNumber() {
		return this.drivemethod;
	}

	public boolean checkParked() {
		return this.parked;
	}

	public void status() {
		System.out.print(this.name);
		System.out.println(" Plate number - " + this.platenumber);
		System.out.print("Size - " + this.size);
		System.out.println(". Max speed - " + this.speed);
		System.out.print("Located at " + this.position);
		if (this.parked) {
			System.out.println(". Parked.");
		} else {
			System.out.println(". Not parked.");
		}
	}

	public void move(int distance) {
		if (this.parked) {
			System.out.println("Unpark first.");
			return;
		}
		if (distance > this.speed || (distance * - 1) > this.speed) {
			System.out.println("Too far. Max speed is - " + this.speed);
			return;
		}
		if (this.parked == false && distance <= this.speed && (distance * - 1) <= this.speed) {
			this.position = this.position + distance;
			System.out.println(this.drivemethod + "" + this.name + " moved a distance of " + distance + " to position " + this.position);
		}
	}
}