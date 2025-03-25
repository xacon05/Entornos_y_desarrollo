package com.mycompany.adriansanchez_ej2_ej.exud4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ana González
 */
public class conversorTest {
    
    public conversorTest() {
    }

    /**
     * Test of main method, of class conversor.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] argumentos = {}; // Usa un array vacío como argumento
        conversor.main(argumentos); 
        // Si el método main no lanza excepciones, la prueba será exitosa
        assertTrue(true);
    }

    /**
     * Test of celsiusAFahrenheit method, of class conversor.
     */
    @Test
    public void testCelsiusAFahrenheit() {
        System.out.println("celsiusAFahrenheit");
        float celsius = 0.0f;
        float expResult = 32.0f; // Resultado esperado
        float result = conversor.celsiusAFahrenheit(celsius); 
        assertEquals(expResult, result, 0.01); // Permitir un margen de error mínimo
    }

    /**
     * Test of fahrenheitACelsius method, of class conversor.
     */
    @Test
    public void testFahrenheitACelsius() {
        System.out.println("fahrenheitACelsius");
        float fahrenheit = 32.0f;
        float expResult = 0.0f; // Resultado esperado
        float result = conversor.fahrenheitACelsius(fahrenheit);
        assertEquals(expResult, result, 0.01); // Permitir un margen de error mínimo
    }
}
