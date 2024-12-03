/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED 
{
    private static final byte[] buffer = new byte[1000];
    private static final String fileName = "fichero.dat";
    private static FileInputStream inputStream = null;
    private static BufferedInputStream inputBuffer = null;

    public static void inicializateFiles() throws FileNotFoundException
    {
        inputStream = new FileInputStream(fileName);
        inputBuffer = new BufferedInputStream(inputStream);
    }
    
    public static int showFileText() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = inputStream.read(buffer)) != -1) 
        {
            System.out.println(new String(buffer));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializateFiles();
            
            int total = showFileText();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( inputBuffer != null && inputStream != null )
                {
                    inputStream.close();
                    inputBuffer.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
