/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author turupawn
 */
public class Ejercicios {
    static void guardar(String nombre_archivo, ArrayList<Producto> productos)
    {
        try
        {
            PrintWriter produc = new PrintWriter(nombre_archivo);

            for(Producto p : productos)
            {
                produc.println(p.nombre + " " + p.categoria+" "+ p.existencias+" "+p.precio);
            }

            produc.close();
        }catch (Exception e)
        {
            System.out.println("Ocurrio un error al guardar.");
        }
    }
    
    static ArrayList<Producto> abrir(String nombre_archivo)
    {
        ArrayList<Producto> prod= new ArrayList<>(); 
        try
        {
            Scanner scanner = new Scanner(new File(nombre_archivo));
            while(scanner.hasNext())
            {
                String nombre = scanner.next();
                 String categoria = scanner.next();
                int existencias = scanner.nextInt();
                double precio = scanner.nextDouble();
                prod.add (new Producto (nombre, categoria, existencias, precio) );
            }
            scanner.close();
        }catch(Exception e)
        {
            System.out.print("Error al leer el archivo");
        }
        return prod;
       
    }
}
