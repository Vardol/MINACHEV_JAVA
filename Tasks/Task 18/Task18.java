import java.util.Random;

public class Task18 {

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
				if ((array[i][j] / 100000) == 0) {
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
				matrix[i][j] = rnd.nextInt(100+1);
        	}
    	}
	}

	public static void main(String[] args) {
		int a[][] = new int[5][5];
		int b[][] = new int[5][5];
		int matrixsumm[][] = new int [5][5];
		int matrixmult[][] = new int [5][5];
		Matrixworker matrixworker = new Matrixworker();
		fillmatrix(a);
		fillmatrix(b);
		printmatrix(a);
		printmatrix(b);
		System.out.println("");
		matrixsumm = matrixworker.sum(a, b);
		printmatrix(matrixsumm);
		System.out.println("");
		matrixmult = matrixworker.mult(a, b);
		printmatrix(matrixmult);
	}
}

