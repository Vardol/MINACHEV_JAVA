import java.util.Scanner;

class Task14 {

    public static double leftrectangles(int segments, double left, double right) {
        double shag = (right - left) / segments;
        double result = 0;
        while (left < right) {
        result = result + left * left * shag;
        left = left + shag;
        }
        return result;
    }

    public static double rightrectangles(int segments, double left, double right) {
        double shag = (right - left) / segments;
        double result = 0;
        while (right > left) {
        result = result + right * right * shag;
        right = right - shag;
        }
        return result;
    }

    public static double simpsons(int segments, double left, double right) {
        double shag = (right - left) / segments;
        double result = left * left + right * right;
        while (left < right) {
        result = result + 4 * (left * left);
        left = left + shag;
        if (left >= right) {
            return result * shag / 3;
        }
        result = result + 2 * (left * left);
        left = left + shag;
        }
        return result * shag / 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of segments - ");
        int n = scanner.nextInt();
        System.out.print("Enter starting point of integral - ");
        double start = scanner.nextDouble();
        System.out.print("Enter ending point of integral - ");
        double end = scanner.nextDouble();
        int choice = 0;
                
        while (choice != 6) {
            System.out.println("");
            System.out.println("Which method to use?");
            System.out.println("1 - left rectangles");
            System.out.println("2 - right rectangles");
            System.out.println("3 - trapezi");
            System.out.println("4 - Simpson's");
            System.out.println("5 - change parameters");
            System.out.println("6 - exit");
            System.out.print("Enter yor choice? ");
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Using left rectangles method = ");
                System.out.println(leftrectangles(n, start, end));
            }
            if (choice == 2) {
                System.out.print("Using right rectangles method = ");
                System.out.println(rightrectangles(n, start, end));
            }
            if (choice == 3) {
                System.out.print("Using trapezi method = ");
                System.out.println((leftrectangles(n, start, end) + rightrectangles(n, start, end)) / 2);
            }
            if (choice == 4) {
                System.out.print("Using Simpson's method = ");
                System.out.println(simpsons(n, start, end));
            }
            if (choice == 5) {
                System.out.print("Enter number of segments - ");
                n = scanner.nextInt();
                System.out.print("Enter starting point of integral - ");
                start = scanner.nextDouble();
                System.out.print("Enter ending point of integral - ");
                end = scanner.nextDouble();
            }
            if (choice == 6) {
                System.out.println("");
                System.out.println("##   #   #  ###       ##   #   #  ###   #");
                System.out.println("# #   # #   #         # #   # #   #     #");
                System.out.println("##     #    ###  ###  ##     #    ###   #");
                System.out.println("# #    #    #         # #    #    #      ");
                System.out.println("##     #    ###       ##     #    ###   #");
            }
        }
    }
}
