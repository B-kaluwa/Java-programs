
public class DivideByZeroInLoop {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        for (int i = 1; i <= 5; i++) {
            try {
                // Attempt to divide by zero in each iteration
                int result = numerator / denominator;
                System.out.println("Result " + i + ": " + result); // This line will not be executed due to exception
            } catch (ArithmeticException e) {
                System.err.println("ArithmeticException in iteration " + i + ": " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
