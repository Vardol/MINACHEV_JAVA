import java.util.Scanner;

class Task10 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to search in");
        char text[] = scanner.nextLine().toCharArray();
        scanner = new Scanner(System.in);
        System.out.println("Enter a string to search for");
        char query[] = scanner.nextLine().toCharArray();
        System.out.println("");
        int match = 0;
        for (int i = 0; i <= text.length - 1; i++) {
            if (text[i] == query[0]) {
                match = 1;
                for (int p = 1; p <= query.length - 1; p++) {
                    if (text[i + p] == query[p]) {
                        match = match + 1;
                    }
                    else {
                        p = query.length;
                    }
                }
                if (match == query.length) {
                    System.out.println("starting element number - " + (i + 1));
                    System.out.println("");
                    for (int p = 0; p <= text.length - 1; p++) {
                        System.out.print(text[p]);
                    }
                    System.out.println("");
                    for (int p = 0; p <= i - 1; p++) {
                        System.out.print(" ");
                    }
                    for (int p = 0; p <= query.length - 1; p++) {
                        System.out.print("^");
                    }
                    System.out.println("- there is your query");
                }
            }
            match = 0;
        }
	}
}
