public interface Cargo {

	public abstract void load(int cargo);

	public abstract void unload(int cargo);

	public abstract int getAvailableCargo();

	public abstract int getCurrentCargo();

}