
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ArchivoCursos 
{
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    ArrayList<Curso> listaDeCursos;
    int contador = 0;
    
    

    public ArchivoCursos() {
        
    }
    
    public void crearArchivo()
    {
        try
        {
            archivoSalida = new ObjectOutputStream(new FileOutputStream("cursos.dat"));
            System.out.println("Archivo creado");
           
        }
        catch(Exception e)
        {
            System.out.println("Error al crear archivo");
            
        }
    }
    
    public void escribirEnElArchivo(Curso curso)
    {
        try
        {
            archivoSalida.reset();
            archivoSalida.writeObject(curso);
            System.out.println("Curso ingresado");
           
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir en archivo"+e);
        }
    }
    
    public ArrayList<Curso> leerEnElArchivo()
    {
        listaDeCursos = new ArrayList<Curso>();
        try
        {
            archivoEntrada = new ObjectInputStream(new FileInputStream("cursos.dat"));
            
            while(true)
            {
                listaDeCursos.add((Curso)archivoEntrada.readObject());
                contador++;
            }
        }
        catch(Exception e)
        {
            System.out.println("Fin del archivo"+e);
        }
        return listaDeCursos;
    }
    
    
   public int devolverContador()
   {
       return contador;
   }
   
    
}
