import java.util.Scanner;

class Task16 {

    public static void main(String[] args) {
        intlist array = new intlist();
        int choice = 0;
        int number = 0;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        while (choice != -1) {
            System.out.println("");
            System.out.println("What do we do?");
            System.out.println("1 - insert element in the end");
            System.out.println("2 - insert element in the beginning");
            System.out.println("3 - insert element in given position");
            System.out.println("4 - delete element in given position");
            System.out.println("5 - get element in given position");
            System.out.println("6 - get number of elements in array");
            System.out.println("7 - reverse array");
            System.out.println("8 - sort array");
            System.out.println("9 - check if array contains a number");
            System.out.println("10 - search for element");
            System.out.println("11 - show array");
            System.out.println("-1 - exit");
            System.out.print("Your choice - ");
            choice = scanner.nextInt();
            System.out.println("");
            if (choice == 1) {
                System.out.print("enter an element to add - ");
                number = scanner.nextInt();
                array.add(number);
                System.out.println("");
            }
            if (choice == 2) {
                System.out.print("enter an element to addto the start of the list - ");
                number = scanner.nextInt();
                array.addtobegin(number);
                System.out.println("");
            }
            if (choice == 3) {
                System.out.print("enter an element to add - ");
                number = scanner.nextInt();
                System.out.print("enter position to insert - ");
                index = scanner.nextInt();
                array.insert(number, index);
                System.out.println("");
            }
            if (choice == 4) {
                System.out.print("enter element index to delete - ");
                index = scanner.nextInt();
                array.delete(index);
                System.out.println("");
            }
            if (choice == 5) {
                System.out.print("enter element index to show - ");
                index = scanner.nextInt();
                System.out.println("");
                System.out.print("element in position " + index);
                System.out.println(" is - " + array.get(index));
            }
            if (choice == 6) {
                System.out.print("array currently contains " + array.reallength);
                System.out.println(" elements.");
            }
            if (choice == 7) {
                array.reverse();
                System.out.println("");
                System.out.println("array reversed");
            }
            if (choice == 8) {
                array.sort();
                System.out.println("");
                System.out.println("array sorted");
            }
            if (choice == 9) {
                System.out.print("enter a number to check - ");
                number = scanner.nextInt();
                if (array.contains(number)) {
                	System.out.println("array contains " + number);
                }
                else {
                	System.out.println("array doesnt contain " + number);
                }
            }
            if (choice == 10) {
                System.out.print("enter a number to search - ");
                number = scanner.nextInt();
                if (array.search(number) == -1) {
                	System.out.println("array doesnt contain " + number);
                }
                else {
                	System.out.print("array contains " + number);
                	System.out.print(" at " + array.search(number));
                	System.out.println(" position;");
                }
            }
            if (choice == 11) {
                array.printarray();
            }
        }
    System.out.println("");
    System.out.println("##   #   #  ###       ##   #   #  ###   #");
    System.out.println("# #   # #   #         # #   # #   #     #");
    System.out.println("##     #    ###  ###  ##     #    ###   #");
    System.out.println("# #    #    #         # #    #    #      ");
    System.out.println("##     #    ###       ##     #    ###   #");
    }
}
