public class FibonacciComparison {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;

        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 30;
        int n3 = 45;
        System.out.println("Fibonacci Calculation for n = " + n1 + " : ");
                measureTime("Recursive", () -> fibonacciRecursive(n1));
        measureTime("Iterative", () -> fibonacciIterative(n1));
        System.out.println("\nFibonacci Calculation for n = " + n2 + " : ");
                measureTime("Recursive", () -> fibonacciRecursive(n2));
        measureTime("Iterative", () -> fibonacciIterative(n2));
        System.out.println("\nFibonacci Calculation for n = " + n3 + " : ");
                measureTime("Recursive", () -> fibonacciRecursive(n3));
        measureTime("Iterative", () -> fibonacciIterative(n3));
    }
    public static void measureTime(String method, Runnable function) {
        long startTime = System.nanoTime();
        long result = -1;
        try {
            if (function instanceof java.util.concurrent.Callable) {
                result = (long) ((java.util.concurrent.Callable<Long>) function).call();
            } else {
                function.run();
            }
        } catch (Exception e) {
            if (method.equals("Recursive")) {
                System.out.println(method + ": Calculation took too long or resulted in a StackOverflowError for larger n.");
                return;
            }
        }
        long endTime = System.nanoTime();
        Double durationMillis = (endTime - startTime) / 1_000_000.0;
        if (!(function instanceof java.util.concurrent.Callable)) {
            System.out.println(method + ": Time taken = " + durationMillis + " ms");
        } else {
            System.out.println(method + ": Result = " + result + ", Time taken = " + durationMillis + " ms");
        }
    }
}