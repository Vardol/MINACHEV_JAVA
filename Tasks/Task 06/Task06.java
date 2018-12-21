class Task06 {
	public static void main(String[] args) {
        int array[] = {6, 4, 63, 7, 19, 8, 1, 52, 5, 140};
        int temp = 0;
        System.out.print("initial given array: " + array[0]);
        for (int i = 1; i <= (array.length - 1); i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println(";");
        for (int i = 0; i <= (array.length - 1) / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - (i + 1)];
            array[array.length - (i + 1)] = temp;
        }
        System.out.print("reverted array: " + array[0]);
        for (int i = 1; i <= (array.length - 1); i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println(";");
	}
}
