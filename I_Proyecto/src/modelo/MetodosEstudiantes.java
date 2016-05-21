
package modelo;

import java.util.ArrayList;

public class MetodosEstudiantes 
{
    ArrayList<Estudiante> listaDeEstudiantes;
    Estudiante estudiante;
    String arregloInformacionConsultada[]= new String[3];

    public MetodosEstudiantes() {
        listaDeEstudiantes=new ArrayList<Estudiante>();
    }
    
    public void agregarEstudiante(String arreglo[])
    {
        estudiante=new Estudiante(arreglo[0], arreglo[1], arreglo[2]);
        listaDeEstudiantes.add(estudiante);
    }
    
    public boolean consultarEstudiante(String cedula)
    {
        boolean encontrado = false;
        
        for (int i = 0; i < listaDeEstudiantes.size(); i++) 
        {
            if(listaDeEstudiantes.get(i).getCarne().equalsIgnoreCase(cedula))
            {
                encontrado=true;
                arregloInformacionConsultada[0]=listaDeEstudiantes.get(i).getCarne();
                arregloInformacionConsultada[1]=listaDeEstudiantes.get(i).getNombre();
                arregloInformacionConsultada[2]=listaDeEstudiantes.get(i).getDireccion();
                
            }
        }
        return encontrado;
    }
    
    public String[] devolverInformacionConsultada()
    {
        return arregloInformacionConsultada;
    }
    
    public void modificarEstudiante(String arreglo[])
    {
        for (int i = 0; i < listaDeEstudiantes.size(); i++) 
        {
            if(listaDeEstudiantes.get(i).getCarne().equalsIgnoreCase(arreglo[0]))
            {
              listaDeEstudiantes.get(i).setNombre(arreglo[1]);
              listaDeEstudiantes.get(i).setDireccion(arreglo[2]);   
            }
        }
    }
    
    public void eliminarEstudiante(String arreglo[])
    {
         for (int i = 0; i < listaDeEstudiantes.size(); i++) 
        {
            if(listaDeEstudiantes.get(i).getCarne().equalsIgnoreCase(arreglo[0]))
            {
              listaDeEstudiantes.remove(i);
            }
        }
    }
    
    //////****Archivos planos***/////
   public ArrayList<Estudiante> devolverLista()
   {
       return listaDeEstudiantes;
   }
   
   public void leerArchivo(ArrayList<Estudiante> lista)
   {
       for (int i = 0; i < lista.size(); i++)
       {
           listaDeEstudiantes.add(lista.get(i));
       }
   }
    
    
    
}
