import java.util.Random;
import java.util.Scanner;

class Task08v2 {
	public static void main(String[] args) {
//declaring variables, generating array of given length and showing it to the user
        int maxposition = -1;
        int i = 0;
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        int arraylength = 0;
        while (arraylength < 2 || arraylength > 100){
            System.out.print("Enter desirable array range between 2 and 100 - ");
            arraylength = scanner.nextInt();
        }
        int array[] = new int[arraylength];
        for (i = 0; i <= (array.length - 1); i++) {
            array[i] = rnd.nextInt(255);
        }
        System.out.print("initial given array: " + array[0]);
        for (i = 1; i <= (array.length - 1); i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println(";");
        int max = array[0];
//sorting
        // taking local maximums left
        while (maxposition != array.length - 1) {
            for (i = 1; maxposition < 0; i++) {
                if (i > array.length - 2) {
                    maxposition = array.length - 1;
                }
                else {
                    if (array[i] > array[i - 1]) {
                        if (array[i] > array[i + 1]){
                            max = array[i];
                            maxposition = i;
                        }
                    }
                    if (array[i] = array[i - 1]) {
                        if (array[i] > array[i + 1]){
                            max = array[i];
                            maxposition = i;
                        }
                    }
                }
            }
            for (i = maxposition; i > 0; i--) {
                if (array[i] > array[i - 1]) {
                    max = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = max;
                }
            }
            if (maxposition != array.length - 1) {
                maxposition = -1;
            }
            
        }
        // taking local minimums right
        maxposition = -1;
        max = array[0];
        while (maxposition != array.length - 1) {
            for (i = 1; maxposition < 0; i++) {
                if (i > array.length - 2) {
                    maxposition = array.length - 1;
                }
                else {
                    if (array[i] < array[i - 1]) {
                        if (array[i] < array[i + 1]){
                            max = array[i];
                            maxposition = i;
                        }
                    }
                }
            }
            for (i = maxposition; i < arraylength -1; i++) {
                if (array[i] < array[i + 1]) {
                    max = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = max;
                }
            }
            if (maxposition != array.length - 1) {
                maxposition = -1;
            }
            
        }

 //           while (array[arraylength - 1] > array[arraylength - 2]) {
 //               for (i = array.length - 1; i > 0; i--) {
 //                   if (array[i] > array[i - 1]) {
 //                       max = array[i];
 //                       array[i] = array[i - 1];
 //                       array[i - 1] = max;
 //                   }
 //               }
 //           }

//showing user sorted array
        System.out.print("array sorted descending: " + array[0]);
        for (i = 1; i <= (array.length - 1); i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println(";");
	}
}
