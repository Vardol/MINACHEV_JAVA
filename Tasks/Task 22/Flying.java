public interface Flying {

	public static final int DEFAULT_HEIGHT = 10;

	public void fly(int distance, int height) {
		if (this.parked) {
			System.out.println("Unpark first.");
			return;
		}
		if (distance > this.speed || (distance * - 1) > this.speed) {
			System.out.println("Too far. Max speed is - " + this.speed);
			return;
		}
		if (height > this.maxheight) {
			System.out.println("Too high. Max height is - " + this.maxheight);
			return;
		}
		if (height <= this.maxheight && distance <= this.speed && (distance * - 1) <= this.speed && this.parked == false) {
			this.position = this.position + distance;
			System.out.println(this.name + " flew a distance of " + distance + " at height " + height + " to position " + this.position);
		}
	}

	public default int getDEFAULT_HEIGHT() {
		return DEFAULT_HEIGHT;
	}

}