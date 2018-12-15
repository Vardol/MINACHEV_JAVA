import java.util.Random;
class Task01 {
	public static void main(String[] args) {
		Random rnd = new Random();
		int summ = rnd.nextInt(40000) * 10;
		int fiveg = summ / 5000;
		int oneg = ( summ % 5000 ) / 1000;
		int fiveh = ( summ % 1000 ) / 500;
		int oneh = ( summ % 500 ) / 100;
		int fifty = ( summ % 100 ) / 50;
		int ten = ( summ % 50 ) / 10;
		System.out.println("cash requested - " + summ);
		System.out.println("5000 - " + fiveg);
		System.out.println("1000 - " + oneg);
		System.out.println("500 - " + fiveh);
		System.out.println("100 - " + oneh);
		System.out.println("50 - " + fifty);
		System.out.println("10 - " + ten);
	}
}