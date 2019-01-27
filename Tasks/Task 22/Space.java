public class Parking {

	private int size;
	private int position;
	private int counter;
//	private Transport parking[];
	private String parkinglots[];
	private String log[][];

	public void park(String platenumber, int size) {
		while (size > 0) {
			this.parkinglots[counter] = platenumber;
			size--;
			counter++;
		}

	}

	private int search(String platenumber) {
		for (int i = 0; i < this.counter; i++) {
			if (this.parkinglots[i] == platenumber) {
				return i;
			}
			return -1;
		}
	}

    public static void delete(int position) {
        for (int i = position + 1; i < this.counter; i++) {
            array[i - 1] = array[i];
        }
        this.parkinglots[this.counter - 1] = "";
        this.counter--;
    }

	public void unpark(String platenumber) {
		if (this.search(platenumber) == -1) {
			System.out.println("No such vehicle parked");
		}
		while (this.search(platenumber) != -1) {
			this.delete(search(platenumber));
		}
	}

	public void showLog() {
		
	}

	public void showParkedTransport() {
		for (int i = 0; i < this.counter; i++) {
			System.out.println(this.parkinglots[i]);
		}
		
	}

	public int getCounter() {
		return this.counter;
	}

	public int getAvailableSpace() {
		return (this.parkinglots.length - this.counter);
	}

	public int getPosition() {
		return this.position;
	}

}