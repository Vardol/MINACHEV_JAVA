import java.util.Scanner;
import java.util.Random;

class Task19 {
    public static void printmatrix(int array[][]) {
        System.out.println();
        System.out.println("matrix:");
        for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
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
        		System.out.print(array[i][j] + ", ");
        	}
       		System.out.println(";");
    	}
    }

    public static void fillmatrix(int matrix[][]) {
        Random rnd = new Random();
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rnd.nextInt(4999+1);
        	}
    	}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("enter matrix size - ");
		int x = scanner.nextInt();
		int matrix[][] = new int[x][x];
		fillmatrix(matrix);
		printmatrix(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == j) {
//					System.out.println("matrix " + i + " , " + j + " was " + matrix[i][j]);
//					System.out.println("matrix " + i + " , " + j + " stays unchanged");
				} else {
					if (j > i) {
//						System.out.println("matrix " + i + " , " + j + " was " + matrix[i][j]);
						matrix[i][j] = matrix[i][j] * 2;
//						System.out.println("matrix " + i + " , " + j + " doubled");
//						System.out.println("matrix " + i + " , " + j + " is now " + matrix[i][j]);
					} else {
//						System.out.println("matrix " + i + " , " + j + " was " + matrix[i][j]);
						matrix[i][j] = matrix[i][j] / 2;
//						System.out.println("matrix " + i + " , " + j + " halved");
//						System.out.println("matrix " + i + " , " + j + " is now " + matrix[i][j]);
					}
				}

			}
//			System.out.println("");
		}
		printmatrix(matrix);

	}
}