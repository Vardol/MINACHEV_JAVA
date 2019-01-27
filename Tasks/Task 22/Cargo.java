public interface Cargo {

	public default void load(int cargo) {
		if (cargo > this.getAvailableCargo()) {
			System.out.println("Too heavy load. Cant load that much. Only have" + (this.cargocapacity - this.currentcargo) + "empty space left");
		} else {
			this.currentcargo = this.currentcargo + cargo;
		}
	}

	public default void unload(int cargo) {
		if (cargo > this.currentcargo) {
			System.out.println("Dont have that much cargo. Only have" + this.currentcargo);
		} else {
			this.currentcargo = this.currentcargo - cargo;
		}
	}

	public default int getAvailableCargo() {
		return (this.CARGO_CAPACITY - this.currentcargo);
	}

	public default int getCurrentCargo() {
		return this.currentcargo;
	}

}