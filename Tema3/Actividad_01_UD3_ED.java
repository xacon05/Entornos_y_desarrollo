package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Actividad_01_UD3_ED {

    private static final int BUFFER_SIZE = 1000;
    private static final byte[] buffer = new byte[BUFFER_SIZE];
    private static final String FILE_NAME = "fichero.dat";

    private static FileInputStream fileInputStream = null;
    private static BufferedInputStream bufferedInputStream = null;

    public static void openFileStreams() throws FileNotFoundException {
        fileInputStream = new FileInputStream(FILE_NAME);
        bufferedInputStream = new BufferedInputStream(fileInputStream);
    }

    public static int readAndShowFileContent() throws IOException {
        int totalBytesRead = 0;
        int bytesRead;

        while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, bytesRead));
            totalBytesRead += bytesRead;
        }

        return totalBytesRead;
    }

    public static void main(String[] args) {
        try {
            openFileStreams();
            int totalBytes = readAndShowFileContent();
            System.out.println("\nTotal bytes read: " + totalBytes);
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (bufferedInputStream != null) bufferedInputStream.close();
                if (fileInputStream != null) fileInputStream.close();
            } catch (IOException ex) {
                System.err.println("Error closing file: " + ex.getMessage());
            }
        }
    }
}
