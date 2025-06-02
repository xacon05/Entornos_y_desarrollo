package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Actividad_01_UD3_ED {

    private static final int TAMAÑO_BUFFER = 1000;
    private static final byte[] buffer = new byte[TAMAÑO_BUFFER];
    private static final String NOMBRE_FICHERO = "fichero.dat";

    private static FileInputStream flujoFichero = null;
    private static BufferedInputStream flujoBuffer = null;

    public static void abrirFlujos() throws FileNotFoundException {
        flujoFichero = new FileInputStream(NOMBRE_FICHERO);
        flujoBuffer = new BufferedInputStream(flujoFichero);
    }

    public static int leerYMostrarContenido() throws IOException {
        int totalBytesLeidos = 0;
        int bytesLeidos;

        while ((bytesLeidos = flujoBuffer.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, bytesLeidos));
            totalBytesLeidos += bytesLeidos;
        }

        return totalBytesLeidos;
    }

    public static void main(String[] args) {
        try {
            abrirFlujos();
            int totalBytes = leerYMostrarContenido();
            System.out.println("\nTotal de bytes leídos: " + totalBytes);
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (flujoBuffer != null) flujoBuffer.close();
                if (flujoFichero != null) flujoFichero.close();
            } catch (IOException ex) {
                System.err.println("Error al cerrar el fichero: " + ex.getMessage());
            }
        }
    }
}
