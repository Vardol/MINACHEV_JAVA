class Task07 {
	public static void main(String[] args) {
        int array[] = {6, 4, 63, 7, 19, 8, 1, 4, 5, 140};
        int result = 0;
        for (int i = 1; i <= array.length - 2; i++) {
            if (array[i] > array[i - 1]) {
                if (array[i] > array[i + 1]){
                    result = result + 1;
                }
            }
        }
		System.out.println("Number of local maximum in array = " + result);
	}
}
