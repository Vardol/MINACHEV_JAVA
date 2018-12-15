import java.util.Random;
class Task02 {
	public static void main(String[] args) {
		Random rnd = new Random();
		int number = rnd.nextInt(255);
		System.out.println(number);
		int one = number % 2;
		int two = (number / 2) % 2;
		int three = (number / 4) % 2;
		int four = (number / 8) % 2;
		int five = (number / 16) % 2;
		int six = (number / 32) % 2;
		int seven = (number / 64) % 2;
		int eight = (number / 128) % 2;
		System.out.print(eight);
		System.out.print(seven);
		System.out.print(six);
		System.out.print(five);
		System.out.print(four);
		System.out.print(three);
		System.out.print(two);
		System.out.print(one);
	}
}