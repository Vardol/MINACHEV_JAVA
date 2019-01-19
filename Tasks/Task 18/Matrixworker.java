class Matrixworker {

	public int[][] sum(int a[][], int b[][]) {
		int sum[][] = new int[5][5];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				sum[i][j] = a[i][j] + b[i][j];
			}
		}
		return sum;

	}

	public int[][] mult(int a[][], int b[][]) {
		int mult[][] = new int[5][5];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				for (int p = 0; p < a.length; p++) {
					mult[i][j] = mult [i][j] + a[i][p] * b[p][j];
				}
			}
		}
		return mult;
	}
}