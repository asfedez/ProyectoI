
package modelo;

import java.util.ArrayList;


public class MetodosCursos {

    ArrayList<Curso> listaDeCursos;
    Curso curso;
    String arregloInformacionConsultada[]= new String[4];

    public MetodosCursos() {
        listaDeCursos=new ArrayList<Curso>();
    }
    
    public void agregarCurso(String arreglo[])
    {
        curso= new Curso(arreglo[0], arreglo[1], Integer.parseInt(arreglo[2]), arreglo[3]);
        listaDeCursos.add(curso);
    }
    
    public boolean consultarCurso(String sigla)
    {
        boolean encontrado = false;
        
        for (int i = 0; i < listaDeCursos.size(); i++) 
        {
            if(listaDeCursos.get(i).getSigla().equalsIgnoreCase(sigla))
            {
                encontrado=true;
                arregloInformacionConsultada[0]=listaDeCursos.get(i).getSigla();
                arregloInformacionConsultada[1]=listaDeCursos.get(i).getNombre();
                arregloInformacionConsultada[2]=""+listaDeCursos.get(i).getCredito();
                arregloInformacionConsultada[3]=listaDeCursos.get(i).getHorario();         
            }
        }
        return encontrado;
    }
    
    public String[] devolverInformacionConsultada()
    {
        return arregloInformacionConsultada;
    }
    
    public void modificarCurso(String arreglo[])
    {
        for (int i = 0; i < listaDeCursos.size(); i++) 
        {
            if(listaDeCursos.get(i).getSigla().equalsIgnoreCase(arreglo[0]))
            {
              listaDeCursos.get(i).setNombre(arreglo[1]);
              listaDeCursos.get(i).setCredito(Integer.parseInt(arreglo[2]));   
              listaDeCursos.get(i).setHorario(arreglo[3]);
            }
        }
    }
    
    public void eliminarCurso(String arreglo[])
    {
         for (int i = 0; i < listaDeCursos.size(); i++) 
        {
            if(listaDeCursos.get(i).getSigla().equalsIgnoreCase(arreglo[0]))
            {
              listaDeCursos.remove(i);
            }
        }
    }
      ///****Archivos Planos**////
    public ArrayList<Curso> getInformacionEnCursos()
    {
        return listaDeCursos;
    }
    
    public void guardarInformacionDeArchivos(ArrayList<Curso> lista)
    {
        for (int i = 0; i < lista.size(); i++) {
            listaDeCursos.add(lista.get(i));
            
        }
    }
    
     public ArrayList<Curso> devolverLista()
   {
       return listaDeCursos;
   }
   
   public void leerArchivo(ArrayList<Curso> lista)
   {
       for (int i = 0; i < lista.size(); i++)
       {
           listaDeCursos.add(lista.get(i));
       }
   }
}
    

