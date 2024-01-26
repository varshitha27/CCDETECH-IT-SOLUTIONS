import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Basic Calculator");

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Choose the operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        double result = 0;
        boolean validOperation = true;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Division by zero is not allowed.");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Invalid operation.");
                validOperation = false;
                break;
        }

        if (validOperation) {
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}
