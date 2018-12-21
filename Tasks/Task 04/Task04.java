import java.util.Scanner;
class Task04 {
	public static void main(String[] args) {
        System.out.println("Enter -1 for endprog");
        Scanner scanner = new Scanner(System.in);
		System.out.print("Enter range from 1 to - ");
        int lastnumber = scanner.nextInt();
        int repetitions = lastnumber - 2;
        lastnumber = lastnumber + lastnumber / 2 + lastnumber * ((lastnumber / 2) - 1);
        System.out.println("You can start entering numbers within range, I will tell you which one you forgot");
        int number = 1;
        for (int i = 0; i <= repetitions; i++) {
            number = scanner.nextInt();
            lastnumber = lastnumber - number;
        }
        System.out.println("You forgot to enter number " + lastnumber);
	}
}
