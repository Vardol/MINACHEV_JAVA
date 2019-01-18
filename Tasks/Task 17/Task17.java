import java.util.Random;

class Task17 {
	public static void main(String[] args) {
		Random rnd = new Random();
		int array[][] = new int [rnd.nextInt(30) + 1][];
		for (int i = 0; i < array.length; i++) {
			array[i] = new int[rnd.nextInt(30) + 1];
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = rnd.nextInt(999999+1);
				if ((array[i][j] / 10) == 0) {
					System.out.print(" ");
				}
				if ((array[i][j] / 100) == 0) {
					System.out.print(" ");
				}
				if ((array[i][j] / 1000) == 0) {
					System.out.print(" ");
				}
				if ((array[i][j] / 10000) == 0) {
					System.out.print(" ");
				}
				if ((array[i][j] / 100000) == 0) {
					System.out.print(" ");
				}
				System.out.print(array[i][j] + ", ");
			}
			System.out.println(";");
			System.out.println("");
		}
		System.out.println("");
		System.out.println("Array was generated with " + array.length + " lines of the following length:");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array [i].length);
		}
	}
}