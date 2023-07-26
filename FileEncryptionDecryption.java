import java.io.*;

public class FileEncryptionDecryption {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
            char choice = br.readLine().toUpperCase().charAt(0);

            if (choice == 'E') {
                System.out.print("Enter the name or path of the file to encrypt: ");
                String inputFileName = br.readLine();
                System.out.print("Enter the name of the output file to save the encrypted data: ");
                String outputFileName = br.readLine();

                encryptFile(inputFileName, outputFileName);
                System.out.println("File encrypted successfully!");
            } else if (choice == 'D') {
                System.out.print("Enter the name or path of the file to decrypt: ");
                String inputFileName = br.readLine();
                System.out.print("Enter the name of the output file to save the decrypted data: ");
                String outputFileName = br.readLine();

                decryptFile(inputFileName, outputFileName);
                System.out.println("File decrypted successfully!");
            } else {
                System.out.println("Invalid choice. Please enter 'E' or 'D'.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void encryptFile(String inputFileName, String outputFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

            int ch;
            while ((ch = br.read()) != -1) {
                char encryptedChar = (char) (ch + 1); // Simple encryption algorithm (shift each character by one position)
                bw.write(encryptedChar);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptFile(String inputFileName, String outputFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

            int ch;
            while ((ch = br.read()) != -1) {
                char decryptedChar = (char) (ch - 1); // Simple decryption algorithm (shift each character back by one position)
                bw.write(decryptedChar);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
