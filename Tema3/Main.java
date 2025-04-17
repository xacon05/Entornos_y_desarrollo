import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal que gestiona las operaciones de una cuenta bancaria
 */
public class Main {
    static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Método principal que muestra un menú y realiza operaciones sobre una cuenta
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        CCuenta cuenta1;
        double saldoActual;
        int opcion = 0;

        cuenta1 = new CCuenta("Juan López", "1000-2365-85-123456789", 2500, 0);

        do {
            try {
                System.out.println("MENÚ DE OPERACIONES");
                System.out.println("-------------------");
                System.out.println("1 - Ingresar");
                System.out.println("2 - Retirar");
                System.out.println("3 - Finalizar");
                opcion = Integer.parseInt(dato.readLine());

                if (opcion == 1) {
                    System.out.println("¿Cuánto desea ingresar?: ");
                    float ingresar = Float.parseFloat(dato.readLine());
                    operativa_cuenta(cuenta1, ingresar, opcion);
                } else if (opcion == 2) {
                    System.out.println("¿Cuánto desea retirar?: ");
                    float retirar = Float.parseFloat(dato.readLine());
                    operativa_cuenta(cuenta1, retirar, opcion);
                } else if (opcion == 3) {
                    System.out.println("Finalizamos la ejecución");
                } else {
                    System.err.println("Opción errónea");
                }

            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (opcion != 3);

        saldoActual = cuenta1.estado();
        System.out.println("El saldo actual es " + saldoActual);
    }

    /**
     * Ejecuta operaciones sobre la cuenta: ingresar o retirar
     * @param cuenta1 Objeto cuenta
     * @param cantidad Cantidad a ingresar o retirar
     * @param opcion Opción seleccionada (1 para ingresar, 2 para retirar)
     */
    public static void operativa_cuenta(CCuenta cuenta1, float cantidad, int opcion) {
        if (opcion == 2) {
            try {
                cuenta1.retirar(cantidad);
            } catch (Exception e) {
                System.out.print("Fallo al retirar");
            }
        } else if (opcion == 1) {
            try {
                System.out.println("Ingreso en cuenta");
                cuenta1.ingresar(cantidad);
            } catch (Exception e) {
                System.out.print("Fallo al ingresar");
            }
        }
    }
}
