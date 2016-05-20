
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoEstudiantes 
{
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    int contador=0;
    
    public void crearArchivo()
    {
        try
        {
            archivoSalida=new ObjectOutputStream(new FileOutputStream("estudiantes.dat"));
            System.out.println("Archivo creado");
        }
        
        catch(Exception e)
        {
            System.out.println("Error al crear archivo "+e);

        }
    }
    
    public void escribirEnElArchivo(Estudiante estudiante)
    {
        try
        {
            archivoSalida.writeObject(estudiante);
            System.out.println("Estudiante agregado");

        }
        
        catch(Exception e)
        {
            System.out.println("Error al agregar estudiante "+e);

        }
    }
    
    public ArrayList<Estudiante> leerEnElArchivo()
    {
        ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
        
        try
        {
            archivoEntrada=new ObjectInputStream(new FileInputStream("estudiantes.dat"));
            
            while(true)
            {
                lista.add((Estudiante) archivoEntrada.readObject());
                contador++;
            }
        }
        catch(Exception e)
        {
             System.out.println("Fin del archivo "+e);

        }
        return lista;
    }
    
    public int devolverContador()
    {
        return contador;
    }

    
}
