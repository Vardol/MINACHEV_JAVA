import java.util.Scanner;

class Task09 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a decimal number from -2147483647 to 2147483647");
        int number = 0;
        int multiplier = 1;
        short symbol = 1;
        char text[] = scanner.next().toCharArray();
        if (text[0] == 45) {
            symbol = -1;
            text[0] = 48;
        }
        for (int i = 0; i <= text.length - 1; i++) {
            if (text[i] < 48 || text[i] > 57) {
                    System.out.println("not a valid decimal number");
                    return;
            }
        }
        for (int i = text.length - 1; i >= 0; i--) {
            number = number + (text[i] - 48) * multiplier;
            multiplier = multiplier * 10;
        }
        number = number * symbol;
        System.out.println(number);
	}
}
