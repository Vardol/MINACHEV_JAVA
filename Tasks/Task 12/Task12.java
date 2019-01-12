class Task12 {

    public static int fib(int n) {
        System.out.println("in fib with n = " + n);
        if (n == 0 || n == 1) {
            return n;
        }
        int result = fib(n - 1) + fib(n - 2);
        System.out.println("out from fib with result = " + result);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
