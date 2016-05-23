
package modelo;

import java.util.ArrayList;
import vista.FRM_MantenimientoMatricula;


public class MetodosMatricula {
    ArrayList <Matricula> listaDeMatriculas;
    String arregloInformacionConsultada[]=new String[4];

    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    FRM_MantenimientoMatricula frm_MantenimientoMatricula;

    boolean estado=true;
    
    public MetodosMatricula(MetodosEstudiantes metodosEstudiantes,MetodosCursos metodosCursos,FRM_MantenimientoMatricula frm_MantenimientoMatricula)
    {
        listaDeMatriculas=new ArrayList <Matricula>();
        this.metodosCursos=metodosCursos;
        this.metodosEstudiantes=metodosEstudiantes;
        this.frm_MantenimientoMatricula=frm_MantenimientoMatricula;

    }
    public void agregarMatricula(String informacion[])
    {
        Matricula temporal=new Matricula(informacion[0], informacion[1], informacion[2], estado);
        listaDeMatriculas.add(temporal);   
    }
    
    
    public boolean consultarMatricula(String codigo)
    {
        boolean existe=false;
        
        for(int contador=0;contador<listaDeMatriculas.size();contador++)
        {
            if(listaDeMatriculas.get(contador).getCodigo().equals(codigo)&&listaDeMatriculas.get(contador).getEstado()==true)
            {
                arregloInformacionConsultada[0]=codigo;
                arregloInformacionConsultada[1]=listaDeMatriculas.get(contador).getCedula();
                metodosEstudiantes.consultarEstudiante(listaDeMatriculas.get(contador).getCedula());
                arregloInformacionConsultada[2]=metodosEstudiantes.devolverInformacionConsultada()[1];
                arregloInformacionConsultada[3]=listaDeMatriculas.get(contador).getSigla();
                            
                frm_MantenimientoMatricula.agregarInformacionTabla(arregloInformacionConsultada);
                
                existe=true;  
            }
  
        }
        return existe;
    }
    public void modificarMatricula(String arreglo[])
    {
        for(int contador=0;contador<listaDeMatriculas.size();contador++)
        {
            if(listaDeMatriculas.get(contador).getCodigo().equals(arreglo[0]))
            {
                listaDeMatriculas.get(contador).setCedula(arreglo[1]);
                listaDeMatriculas.get(contador).setSigla(arreglo[2]);
            }
        }
    }
    public void eliminarMatricula(String arreglo[])
    {
        for(int contador=0;contador<listaDeMatriculas.size();contador++)
        {
            if(listaDeMatriculas.get(contador).getCodigo().equals(arreglo[0])&&listaDeMatriculas.get(contador).getSigla().equals(arreglo[1]))
            {
                listaDeMatriculas.get(contador).setEstado(false);
            }
        }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    } 
    public String devolverCodigo()
    {
        String codigo= "0000";
        if(listaDeMatriculas.size()==0)
        {
            codigo+=1;
        }
        else
        {
            int numero=Integer.parseInt(listaDeMatriculas.get(listaDeMatriculas.size()-1).getCodigo());
            numero++;
            codigo="0000"+numero;
        }
        codigo=codigo.substring(codigo.length()-5, codigo.length());
        return codigo; 
    }
    
    /****Archivos*///
  
    public ArrayList<Matricula> devolverLista()
   {
       return listaDeMatriculas;
   }
   
   public void leerArchivo(ArrayList<Matricula> lista)
   {
       for (int i = 0; i < lista.size(); i++)
       {
           listaDeMatriculas.add(lista.get(i));
       }
   }

}
