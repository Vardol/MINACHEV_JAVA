import java.util.Scanner;
class Task03 {
	public static void main(String[] args) {
        System.out.println("Enter -1 for endprog");
        Scanner scanner = new Scanner(System.in);
		int result = 0;
		int positioncounter = 1;
		int currentnumber = scanner.nextInt();
		int digitssum = 0;
		int prime = 1;
		while (currentnumber != -1) {
			System.out.println(currentnumber);
			while (currentnumber != 0) {
				digitssum = digitssum + (currentnumber % 10);
				currentnumber = currentnumber / 10;
			}
			System.out.println("digits summ = " + digitssum);
			if (digitssum == 2 || digitssum == 3) {
            	prime = 1;
        	}
        	for (int divider = 2; divider * divider <= digitssum; divider++) {
            	if (digitssum % divider == 0) {
            	  	prime = 0;
            	}
        	}
        	if (digitssum == 1) {
            	prime = 0;
        	}
        	System.out.println("current number position = " + positioncounter);
        	if (prime == 1) {
        		if (result == 0) {
        			result = positioncounter;
        		}
        		else {
        			result = result * positioncounter;
        		}
        		System.out.println("PRIME digits summ");
        	}
        	else {
        		System.out.println("NOT PRIME digits summ");
        	}
			System.out.println("CURRENT RESULT = " + result);
			positioncounter++;
			currentnumber = scanner.nextInt();
			prime = 1;
			digitssum = 0;
		}

	}
		
}
