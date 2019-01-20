import java.util.Scanner;
import java.util.Random;

class Task20 {
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
        		System.out.print(array[i][j] + " ");
        	}
       		System.out.println(";");
    	}
    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = 0;
		while (x < 2 || x > 47) {
			System.out.print("enter matrix size in range from 2 to 47 (fullscreen for a nice looking big matrix) - ");
			x = scanner.nextInt();
			if (x < 2 || x > 47) {
				System.out.println("matrix size out of range");
			}
		}
		int matrix[][] = new int[x][x];
		int number = 1;
		int i = 0;
		int j = 0;
		int p = 0;
		while (number <= matrix.length * matrix.length) {
			while (i <= matrix[j].length - 1 - p) {
				matrix[j][i] = number;
				number++;
				i++;
			}
			i--;
			j++;
			while (j <= matrix.length - 1 - p) {
				matrix[j][i] = number;
				number++;
				j++;
			}
			j--;
			i--;
			while (i >= 0 + p) {
				matrix[j][i] = number;
				number++;
				i--;
			}
			i++;
			j--;
			p++;
			while (j >= 0 + p) {
				matrix[j][i] = number;
				number++;
				j--;
			}
			j++;
			i++;
		}
		printmatrix(matrix);
	}
}