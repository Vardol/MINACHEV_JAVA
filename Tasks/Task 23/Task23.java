public class Task23{

	public static void main(String[] args) {
		MyScanner scanner = new MyScanner("numbers.txt");
		int integer = 0;

		integer = scanner.nextInt();
		System.out.println("result = " + integer);
		integer = integer * -2;
		System.out.println("result multyplied by -2 = " + integer);
	}
}