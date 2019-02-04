public class Parking {

	private int size;
	private int position;
	private int counter;
	private Transport parking[];
//	private String log[][];

	public Parking(int size, int position) {
		this.size = size;
		this.position = position;
		this.counter = 0;
		this.parking = new Transport[size - 1];

	}

	public void park(Transport transport, int size) {
		if (size > this.getAvailableSpace()) {
			System.out.println("No free space");
			return;
		}
		if (size <= this.getAvailableSpace()) {
			while (size > 0) {
				this.parking[counter] = transport;
				size--;
				counter++;
			}
			System.out.println("Parked");
		}

	}

	private int search(String platenumber) {
		for (int i = 0; i < this.counter; i++) {
			if (this.parking[i].getPlateNumber().equals(platenumber)) {
				return i;
			}
		}
		return -1;
	}

    public void delete(int position) {
        for (int i = position + 1; i < this.counter; i++) {
            this.parking[i - 1] = this.parking[i];
        }
        this.parking[this.counter - 1] = null;
        this.counter--;
    }

	public void unpark(Transport transport) {
		if (this.search(transport.getPlateNumber()) == -1) {
			System.out.println("No such vehicle parked");
			return;
		}
		while (this.search(transport.getPlateNumber()) != -1) {
			this.delete(search(transport.getPlateNumber()));
		}
	}

//	public void showLog() {
//		
//	}

	public void showParkedTransport() {
		for (int i = 0; i < this.counter; i++) {
			System.out.println(this.parking[i].getName());
			System.out.println(this.parking[i].getPlateNumber());
			System.out.println("");
		}
		
	}

	public int getCounter() {
		return this.counter;
	}

	public int getAvailableSpace() {
		return (this.parking.length - this.counter);
	}

	public int getPosition() {
		return this.position;
	}

}