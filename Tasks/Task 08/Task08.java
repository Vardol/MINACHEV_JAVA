class Task08 {
	public static void main(String[] args) {
        int array[] = {6, 4, 63, 7, 19, 8, 1, 52, 5, 140};
        int max = array[0];
        int temp = 0;
        int maxposition = 0;
        int i = 0;
        System.out.print("initial given array: " + array[0]);
        for (i = 1; i <= (array.length - 1); i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println(";");
        for (int p = 0; p <= array.length - 2; p++) {
            for (i = p; i <= array.length - 1; i++) {
                if (array[i] > max) {
                    max = array[i];
                    maxposition = i;
                }
            }
            array[maxposition] = array[p];
            array[p] = max;
            max = array[p + 1];
            maxposition = p + 1;
        }
        System.out.print("array sorted descending: " + array[0]);
        for (i = 1; i <= (array.length - 1); i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println(";");
	}
}
