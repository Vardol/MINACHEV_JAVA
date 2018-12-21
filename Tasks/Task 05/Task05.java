class Task05 {
	public static void main(String[] args) {
        int array[] = {6, 4, 63, 7, 19, 8, 1, 52, 5, 140};
        int max = array[0];
        int min = array[0];
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
		System.out.println("Maximum number in array = " + max);
        System.out.println("Minimum number in array = " + min);
	}
}
