import java.util.InputMismatchException;
import java.util.Scanner;

public class Divide {
    public static int quotient(int num, int denom) throws ArithmeticException {
        if (denom == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return num / denom;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        do {
            try {
                System.out.println("Enter num1");
                int num = scanner.nextInt();
                System.out.println("Enter num2");
                int denom = scanner.nextInt();
                int result = quotient(num, denom);
                System.out.printf("Result: %d/%d=%d\n", num, denom, result);
                continueLoop = false;
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Exception: " + inputMismatchException);
                scanner.nextLine(); // Clear the input buffer
                System.out.println("Please Enter Integers");
            } catch (ArithmeticException arithmeticException) {
                System.err.println("Exception: " + arithmeticException);
                System.out.println("Zero is an invalid denominator");
            }
        } while (continueLoop);

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
