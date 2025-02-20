import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Encryption/Decryption Program ---");
            System.out.println("1. Encrypt Text");
            System.out.println("2. Decrypt Text");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    encryptText(scanner);
                    break;
                case 2:
                    decryptText(scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void encryptText(Scanner scanner) {
        System.out.println("\n--- Encryption ---");
        System.out.print("Enter the text to encrypt: ");
        String text = scanner.nextLine();
        System.out.print("Choose algorithm (1. Caesar Cipher, 2. Vigenère Cipher): ");
        int algorithmChoice = scanner.nextInt();
        scanner.nextLine();

        if (algorithmChoice == 1) {
            System.out.print("Enter the shift value (key) for Caesar Cipher: ");
            int shift = scanner.nextInt();
            scanner.nextLine();
            String encryptedText = caesarCipherEncrypt(text, shift);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (algorithmChoice == 2) {
            System.out.print("Enter the key for Vigenère Cipher: ");
            String key = scanner.nextLine();
            String encryptedText = vigenereCipherEncrypt(text, key);
            System.out.println("Encrypted Text: " + encryptedText);
        } else {
            System.out.println("Invalid algorithm choice.");
        }
    }

    private static void decryptText(Scanner scanner) {
        System.out.println("\n--- Decryption ---");
        System.out.print("Enter the text to decrypt: ");
        String text = scanner.nextLine();
        System.out.print("Choose algorithm (1. Caesar Cipher, 2. Vigenère Cipher): ");
        int algorithmChoice = scanner.nextInt();
        scanner.nextLine();

        if (algorithmChoice == 1) {
            System.out.print("Enter the shift value (key) for Caesar Cipher: ");
            int shift = scanner.nextInt();
            scanner.nextLine();
            String decryptedText = caesarCipherDecrypt(text, shift);
            System.out.println("Decrypted Text: " + decryptedText);
        } else if (algorithmChoice == 2) {
            System.out.print("Enter the key for Vigenère Cipher: ");
            String key = scanner.nextLine();
            String decryptedText = vigenereCipherDecrypt(text, key);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Invalid algorithm choice.");
        }
    }


    private static String caesarCipherEncrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }


    private static String caesarCipherDecrypt(String text, int shift) {
        return caesarCipherEncrypt(text, 26 - shift);
    }


    private static String vigenereCipherEncrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                int shift = key.charAt(keyIndex % key.length()) - 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
                keyIndex++;
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }


    private static String vigenereCipherDecrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                int shift = key.charAt(keyIndex % key.length()) - 'a';
                result.append((char) ((ch - base - shift + 26) % 26 + base));
                keyIndex++;
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}