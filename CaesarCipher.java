import java.io.*;
import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the key (number of positions to shift): ");
        int shift = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Do you want to (E)ncrypt or (D)ecrypt? ");
        char choice = scanner.nextLine().toUpperCase().charAt(0);

        if (choice == 'E') {
            processFile(filePath, shift, true);
            System.out.println("File encrypted successfully.");
        } else if (choice == 'D') {
            processFile(filePath, shift, false);
            System.out.println("File decrypted successfully.");
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    private static void processFile(String filePath, int shift, boolean encrypt) throws IOException {
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String outputFile = filePath.substring(0, filePath.lastIndexOf('.')) + (encrypt ? "_encrypted.txt" : "_decrypted.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(caesarCipher(line, shift, encrypt));
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    private static String caesarCipher(String text, int shift, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        shift = encrypt ? shift : -shift;

        for (char character : text.toCharArray()) {
            if (character >= 'a' && character <= 'z') {
                char shifted = (char) (((character - 'a' + shift + 26) % 26) + 'a');
                result.append(shifted);
            } else if (character >= 'A' && character <= 'Z') {
                char shifted = (char) (((character - 'A' + shift + 26) % 26) + 'A');
                result.append(shifted);
            } else {
                result.append(character); // Non-alphabetic characters are not shifted
            }
        }

        return result.toString();
    }
}
