
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoUsuarios {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    ArrayList<Usuario> arrayUsuario;
    int contador = 0;
    
    
    public void crearArchivo()
    {
        try
        {
            archivoSalida = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
            System.out.println("Archivo creado");
           
        }
        catch(Exception e)
        {
            System.out.println("Error al crear archivo "+e);
            
        }
    }
    
    public void escribirEnElArchivo(Usuario usuario)
    {
        try
        {
            archivoSalida.writeObject(usuario);
            System.out.println("Usuario ingresado");
           
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir en archivo"+e);
        }
    }
    
    public ArrayList<Usuario> leerEnElArchivo()
    {
        arrayUsuario = new ArrayList<Usuario>();
        try
        {
            archivoEntrada = new ObjectInputStream(new FileInputStream("usuarios.dat"));
            
            while(true)
            {
                arrayUsuario.add((Usuario)archivoEntrada.readObject());
                contador++;
            }
        }
        catch(Exception e)
        {
            System.out.println("Fin del archivo"+e);
        }
        return arrayUsuario;
    }
    
    
   public int devolverContador()
   {
       return contador;
   }
    
}
