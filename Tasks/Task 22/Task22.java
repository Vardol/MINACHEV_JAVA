import java.util.Scanner;

public class Task22 {

	public void showTransport(transport[]) {
		for (int i = 0; i < transport.length; i++) {
			System.out.print(i + 1 + ". ");
			System.out.print(transport[i].getName() + ". ");
			System.out.println("Plate number" + transport[i].getPlateNumber());
			System.out.println("Plate number" + transport[i].getPosition());
			System.out.println("");
		}
		
	}

	public static void main(String[] args) {

		Parking parking = new Parking(15, 5000);

		Transport mytransport[] = new Transport[10];
		mytransport[0] = new Airplane();
		mytransport[1] = new Bicycle();
		mytransport[2] = new Car();
		mytransport[3] = new CargoPlane();
		mytransport[4] = new Glider();
		mytransport[5] = new MilitaryAirplane();
		mytransport[6] = new Spaceship();
		mytransport[7] = new Tank();
		mytransport[8] = new Truck();
		mytransport[9] = new MilitaryAirplane();

		showTransport(mytransport);
		System.out.println("Parking is located at position " + parking.getPosition());

		int choice = 1;
		int value = 0;
		Scanner scanner = new Scanner(System.in);


		System.out.println("");
		System.out.println("What do we do?");
		System.out.println();
		while (choice > 0) {
			System.out.println("1 - move");
			System.out.println("2 - shoot");
			System.out.println("3 - load");
			System.out.println("4 - unload");
			System.out.println("5 - status");
			System.out.println("0 - leave");
			choice = scanner.nextInt();
			if (choice == 1) {
				System.out.print("Which transport (1 - 10) - ");
				choice = scanner.nextInt();
				System.out.print("Distance - ");
				value = scanner.nextInt();
				mytransport[choice].move(value);
				System.out.print("Move complete");
			}
			if (choice == 2) {
				System.out.print("Which transport (1 - 10) - ");
				choice = scanner.nextInt();
				try {
					mytransport[choice].shoot();
				} catch (Throwable e) {
					System.out.print(transport[i].getName() + "cant shoot!");
				}
			}
			if (choice == 3) {

			}
			if (choice == 4) {

			}
			if (choice == 5) {
				showTransport(mytransport);
				System.out.println("Parking is located at position " + parking.getPosition());
			}
	}
}