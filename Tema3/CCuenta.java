/**
 * Clase que representa una cuenta bancaria.
 * Permite realizar operaciones básicas como ingresar, retirar y consultar saldo.
 * @author Ana
 */
public class CCuenta {

    protected String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInterés;

    /**
     * Constructor vacío
     */
    public CCuenta() {
    }

    /**
     * Constructor con parámetros
     * @param nom Nombre del titular
     * @param cue Número de cuenta
     * @param sal Saldo inicial
     * @param tipo Tipo de interés
     */
    public CCuenta(String nom, String cue, double sal, double tipo) {
        nombre = nom;
        cuenta = cue;
        saldo = sal;
        tipoInterés = tipo;
    }

    /**
     * Asigna un nombre al titular
     * @param nom Nombre del titular
     */
    public void asignarNombre(String nom) {
        nombre = nom;
    }

    /**
     * Obtiene el nombre del titular
     * @return Nombre del titular
     */
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * Consulta el saldo disponible
     * @return Saldo actual
     */
    public double estado() {
        return saldo;
    }

    /**
     * Ingresa una cantidad en la cuenta
     * @param cantidad Cantidad a ingresar
     * @throws Exception Si la cantidad es negativa
     */
    public void ingresar(double cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede ingresar una cantidad negativa");
        }
        setSaldo(saldo + cantidad);
    }

    /**
     * Retira una cantidad de la cuenta
     * @param cantidad Cantidad a retirar
     * @throws Exception Si la cantidad es negativa o si el saldo es insuficiente
     */
    public void retirar(double cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede retirar una cantidad negativa");
        }
        if (estado() < cantidad) {
            throw new Exception("No hay suficiente saldo");
        }
        setSaldo(saldo - cantidad);
    }

    /**
     * Obtiene el número de cuenta
     * @return Número de cuenta
     */
    public String obtenerCuenta() {
        return cuenta;
    }

    /**
     * Asigna el número de cuenta
     * @param cuenta Número de cuenta
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Asigna el saldo de la cuenta
     * @param saldo Saldo a asignar
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el tipo de interés
     * @return Tipo de interés
     */
    public double getTipoInterés() {
        return tipoInterés;
    }

    /**
     * Asigna el tipo de interés
     * @param tipoInterés Tipo de interés
     */
    public void setTipoInterés(double tipoInterés) {
        this.tipoInterés = tipoInterés;
    }
}
