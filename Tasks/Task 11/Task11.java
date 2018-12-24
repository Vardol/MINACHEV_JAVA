import java.util.Random;
import java.util.Scanner;

class Task11 {
	public static void main(String[] args) {
//declaring variables, generating array of given length and showing it to the user
        int i = 0;
        int query = 0;
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        int arraylength = 0;
        while (arraylength < 3 || arraylength > 100){
            System.out.print("Enter desirable array range between 3 and 100 - ");
            arraylength = scanner.nextInt();
        }
        int array[] = new int[arraylength];
        int left = 0;
        int mid = (arraylength - 1) / 2;
        int right = arraylength - 1;
        for (i = 0; i <= (array.length - 1); i++) {
            System.out.print("Enter " + (i + 1) + " element of the array - ");
            array[i] = scanner.nextInt();
        }
        System.out.print("initial given array: " + array[0]);
        for (i = 1; i <= (array.length - 1); i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println(";");
        int max = array[0];
        int maxposition = 0;
// sorting
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

//showing user sorted array
        System.out.println("array sorted descending:");
        System.out.print(array[0]);
        for (i = 1; i <= (array.length - 1); i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println(";");

//binary search
        System.out.print("Enter a number to look for - ");
        query = scanner.nextInt();
        while (array[mid] != query && array[right] != query) {
            if (mid == left && query != array[right]) {
                System.out.println("query not found");
                return;
            }
            if (query > array[mid]) {
                right = mid;
            }
            else {
                left = mid;
            }
            mid = (right - left) / 2 + left;
        }
        if (array[right] == query) {
            mid = right;
        }
//showing user sorted array
        System.out.println("array sorted descending:");
        System.out.print(array[0]);
        for (i = 1; i <= (array.length - 1); i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println(";");
// showing search results

//        for (i = mid; i > 0; i--) {        // visualizes results if number are 1 - digit only.
//            System.out.print("   ");
//        }
//        System.out.println("^");
//        for (i = mid; i > 0; i--) {
//            System.out.print("   ");
//        }
//        System.out.println("|");
        System.out.println("Your query is " + (mid + 1) + " element of the array");
	}
}
