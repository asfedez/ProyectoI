
package modelo;

import java.util.ArrayList;


public class MetodosMatricula {
    ArrayList <Matricula> arrayMatricula;
    String arregloInformacionConsultada[]=new String[4];

    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;

    boolean estado;
    
    public MetodosMatricula(MetodosEstudiantes metodosEstudiantes,MetodosCursos metodosCursos, /*FRM_MantenimientoMatricula frm_MantenimientoMatricula*/)
    {
        arrayMatricula=new ArrayList <Matricula>();
        this.metodosCursos=metodosCursos;
        this.metodosEstudiantes=metodosEstudiantes;

    }
    public void agregarMatricula(String informacion[])
    {
        Matricula temporal=new Matricula(informacion[0], informacion[1], informacion[2], true);
        arrayMatricula.add(temporal);    
    }
    
    
    public boolean consultarMatricula(String codigo)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(codigo)&&arrayMatricula.get(contador).getEstado()==true)
            {
                arregloInformacionConsultada[0]=codigo;
                arregloInformacionConsultada[1]=arrayMatricula.get(contador).getCedula();
                metodosEstudiantes.consultarEstudiante(arrayMatricula.get(contador).getCedula());
                arregloInformacionConsultada[2]=metodosEstudiantes.devolverInformacionConsultada()[0];
                arregloInformacionConsultada[3]=arrayMatricula.get(contador).getSigla();
                
                
                
                //frm_MantenimientoMatricula.agregarInformacionTabla(arregloInformacionConsultada);
                
                existe=true;  
            }
  
        }
        return existe;
    }
    public void modificarMatricula(String arreglo[])
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(arreglo[0]))
            {
                arrayMatricula.get(contador).setCedula(arreglo[1]);
                arrayMatricula.get(contador).setSigla(arreglo[2]);
            }
        }
    }
    public void eliminarMatricula(String arreglo[])
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(arreglo[0])&&arrayMatricula.get(contador).getSigla().equals(arreglo[1]))
            {
                arrayMatricula.get(contador).setEstado(false);
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
        if(arrayMatricula.size()==0)
        {
            codigo+=1;
        }
        else
        {
            int numero=Integer.parseInt(arrayMatricula.get(arrayMatricula.size()-1).getCodigo());
            numero++;
            codigo="0000"+numero;
        }
        codigo=codigo.substring(codigo.length()-5, codigo.length());
        return codigo; 
    }
    
    /****Archivos*///
/*    
    public ArrayList<Matricula> devolverLista()
   {
       return arrayMatricula;
   }
   
   public void leerArchivo(ArrayList<Matricula> lista)
   {
       for (int i = 0; i < lista.size(); i++)
       {
           arrayMatricula.add(lista.get(i));
       }
   }
    */
}
