public interface Flying {

	public static final int DEFAULT_HEIGHT = 10;

	public default void fly(int distance, int height);

	public default int getDEFAULT_HEIGHT();

}