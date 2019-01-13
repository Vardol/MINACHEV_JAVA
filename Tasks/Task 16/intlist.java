public class intlist {
    int array[];
    int reallength;
    final int MAX_SIZE = 10;

    public intlist() {
        this.array = new int[MAX_SIZE];
        this.reallength = 0;
    }

    void add(int number) {
        if (this.reallength < MAX_SIZE) {
            this.array[reallength] = number;
            this.reallength++;
            return;
        }
        System.out.println("ARRAY FULL! Delete one of the elements before adding new one");
    }
    void addtobegin(int number) {
        if (this.reallength == MAX_SIZE) {
            System.out.println("ARRAY FULL! Delete one of the elements before adding new one");
            return;
        }
        for (int i = this.reallength; i > 0; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[0] = number;
        this.reallength++;
    }

    int get(int index) {
        return this.array[index - 1];
    }

    void insert(int number, int index) {
        if (this.reallength == MAX_SIZE) {
            System.out.print("ARRAY FULL! Delete one of the elements before adding new one");
        }
        for (int i = this.reallength; i > index - 1; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[index - 1] = number;
        this.reallength++;
    }

    void delete(int index) {
        if (this.reallength == 0) {
            System.out.print("ARRAY EMPTY! Add an element before deleting");
            return;
        }
        for (int i = index - 1; i <= this.reallength - 2; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[this.reallength - 1] = 0;
        this.reallength--;
        }

    void printarray() {
        System.out.print("array:");
        for (int i = 0; i <= this.reallength - 1; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println(";");
    }
    void reverse() {
        int temp = 0;
        for (int i = 0; i < (this.reallength / 2); i++) {
            temp = this.array[i];
            this.array[i] = this.array[this.reallength - 1 - i];
            this.array[this.reallength - 1 - i] = temp;
        }
    }
    void sort() {
        int temp = 0;
        int max = -2147483647;
        int maxposition = 0;
        for (int p = 0; p <= this.reallength - 1; p++) {
            maxposition = p;
            max = -2147483647;
            for (int i = p; i <= this.reallength - 1; i++) {
                if (this.array[i] >= max) {
                    max = this.array[i];
                    maxposition = i;
                }
            }
        temp = this.array[p];
        this.array[p] = this.array[maxposition];
        this.array[maxposition] = temp;
        }
    }
    boolean contains(int number) {
        for (int i = 0; i <= this.reallength - 1; i++) {
            if (this.array[i] == number) {
                return true;
            }
        }
        return false;
    }
    int search(int number) {
        for (int i = 0; i <= this.reallength - 1; i++) {
            if (this.array[i] == number) {
                return i + 1;
            }
        }
        return -1;
    }
}
