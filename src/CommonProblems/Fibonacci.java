package CommonProblems;

public class Fibonacci {

    public Fibonacci() {}

    public void calculate(int n) {
        try {
            System.out.println("Recursively calculate fibonacci of f(" + n + ") = " + recursively(n));
            System.out.println("Linearly calculate fibonacci of f(" + n + ") = " + linearly(n));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public int recursively(int n) throws Exception {
        if (n < 0) {
            throw new Exception("Number n cannot be negative");
        }
        if (n <= 1) {
            return 1;
        }
        return recursively(n - 1) + recursively(n - 2);
    }

    public int linearly(int n) throws Exception {
        if (n < 0) {
            throw new Exception("Number n cannot be negative");
        }
        int[] fib = new int[2];
        fib[0] = 0;
        fib[1] = 1;
        int result = 1;

        for (int i = 0; i < n; i++) {
            result = fib[1] + fib[0];
            fib[0] = fib[1];
            fib[1] = result;
        }
        return result;
    }
}
