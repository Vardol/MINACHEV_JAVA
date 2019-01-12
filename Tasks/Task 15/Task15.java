import java.util.Scanner;

class Task15 {

    public static int realarraylength(int array[]) {
        int result = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] != 0) {
                result = result + 1;
            }
        }
        return result;
    }
    public static void insertinstart(int array[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to insert - ");
        int number = scanner.nextInt();
        int currentlength = realarraylength(array);
        if (currentlength == array.length) {
            System.out.print("ATTENTION! ARRAY FULL! First element will be lost. Please confirm Y/N? ");
            char confirmation = scanner.next().charAt(0);
            if (confirmation == 'N' || confirmation == 'n') {
                return;
            }
        }
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = number;
    }

    public static void insertinend(int array[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to insert - ");
        int number = scanner.nextInt();
        int currentlength = realarraylength(array);
        if (currentlength < array.length) {
            array[currentlength] = number;
            return;
        }
        System.out.print("ATTENTION! ARRAY FULL! Last element will be lost. Please confirm Y/N? ");
        char confirmation = scanner.next().charAt(0);
        if (confirmation == 'N' || confirmation == 'n') {
            return;
        }
        for (int i = 0; i <= array.length - 2; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = number;
    }

    public static void insertinposition(int array[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to insert - ");
        int number = scanner.nextInt();
        int currentlength = realarraylength(array);
        System.out.print("Enter position to insert (1 - " + currentlength);
        System.out.print(") - ");
        int position = scanner.nextInt();
        if (currentlength == array.length) {
            System.out.print("ATTENTION! ARRAY FULL! Last element will be lost. Please confirm Y/N? ");
            char confirmation = scanner.next().charAt(0);
            if (confirmation == 'N' || confirmation == 'n') {
                return;
            }
        }
        for (int i = array.length - 1; i > position - 1; i--) {
            array[i] = array[i - 1];
        }
        array[position - 1] = number;
    }

    public static void deleteinposition(int array[]) {
        Scanner scanner = new Scanner(System.in);
        int currentlength = realarraylength(array);
        System.out.print("Enter element position to delete (1 - " + currentlength);
        System.out.print(") - ");
        int position = scanner.nextInt();
        for (int i = position - 1; i <= array.length - 2; i++) {
            array[i] = array[i + 1];
        }
        array[currentlength - 1] = 0;
        }

    public static void showarray(int array[]) {
        System.out.print("array: ");
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int massive[] = new int[6];
        massive[0] = -3;
        massive[1] = 4;
        massive[2] = 7;
        massive[3] = 12;
        massive[4] = 1;
        massive[5] = -5;
        showarray(massive);
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while (choice != 6) {
            System.out.println("");
            System.out.println("What do we do?");
            System.out.println("1 - insert element in the beginning");
            System.out.println("2 - insert element in the end");
            System.out.println("3 - insert element in given position");
            System.out.println("4 - delete element in given position");
            System.out.println("any number - show array");
            System.out.println("6 - exit");
            System.out.print("Your choice - ");
            choice = scanner.nextInt();
            System.out.println("");
            if (choice == 1) {
                insertinstart(massive);
                System.out.println("");
                System.out.println("Changes saved:");
            }
            if (choice == 2) {
                insertinend(massive);
                System.out.println("");
                System.out.println("Changes saved:");
            }
            if (choice == 3) {
                insertinposition(massive);
                System.out.println("");
                System.out.println("Changes saved:");
            }
            if (choice == 4) {
                deleteinposition(massive);
                System.out.println("");
                System.out.println("Changes saved:");
            }
            showarray(massive);
        }
    System.out.println("");
    System.out.println("##   #   #  ###       ##   #   #  ###   #");
    System.out.println("# #   # #   #         # #   # #   #     #");
    System.out.println("##     #    ###  ###  ##     #    ###   #");
    System.out.println("# #    #    #         # #    #    #      ");
    System.out.println("##     #    ###       ##     #    ###   #");
    }
}
