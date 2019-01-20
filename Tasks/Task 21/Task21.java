import java.util.Scanner;

public class Task21 {

	public static void main(String[] args) {
		TV tv = new TV();
		remote remote = new remote();
		int choice = 1;
		int temp;
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
		System.out.println("At last, you are sitting on your favorite sofa, nochos and beer on a table in front of you.");
		System.out.println("You grab a remote, and what do you do?");
		System.out.println();
		while (choice > 0) {
			System.out.println("1 - check the TV");
			System.out.println("2 - press Power button");
			System.out.println("3 - switch channel");
			System.out.println("4 - next channel");
			System.out.println("5 - previous channel");
			System.out.println("6 - watch TV and drink your beer");
			System.out.println("7 - see the timetable");
			System.out.println("0 - leave");
			choice = scanner.nextInt();
			if (choice == 1) {
				tv.status();
			}
			if (choice == 2) {
				remote.power(tv);
			}
			if (choice == 3) {
				System.out.println("Which channel to turn (10 channels available)? ");
				temp = scanner.nextInt();
				remote.changechannel(tv, temp);
			}
			if (choice == 4) {
				remote.nextchannel(tv);
			}
			if (choice == 5) {
				remote.prevchannel(tv);
			}
			if (choice == 6) {
				tv.watch();
			}
			if (choice == 7) {
				tv.timetable();
			}
		}
	}
}