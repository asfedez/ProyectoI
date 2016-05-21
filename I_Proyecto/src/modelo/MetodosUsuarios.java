
package modelo;

import java.util.ArrayList;


public class MetodosUsuarios {
    
    private ArrayList <Usuario> listaDeUsuarios;
    String arregloInformacionConsultada[]=new String[5];
    String tipo;
    
    public MetodosUsuarios()
    {
        listaDeUsuarios=new ArrayList <Usuario>();
    }
    public void agregarUsuario(String informacion[])
    {
        Usuario temporal= new Usuario(informacion[0], informacion[1], informacion[2],informacion[3],informacion[4]);
        listaDeUsuarios.add(temporal);
        
    }
    
    
    public boolean consultarUsuario(String cedula)
    {
        boolean existe=false;
        
        for(int contador=0;contador<listaDeUsuarios.size();contador++)
        {
            if(listaDeUsuarios.get(contador).getCedula().equals(cedula))
            {
                arregloInformacionConsultada[0]=listaDeUsuarios.get(contador).getCedula();
                arregloInformacionConsultada[1]=listaDeUsuarios.get(contador).getNombreCompleto();
                arregloInformacionConsultada[2]=listaDeUsuarios.get(contador).getNombreUsuario();
                arregloInformacionConsultada[3]=listaDeUsuarios.get(contador).getContrasenna();
                arregloInformacionConsultada[4]=listaDeUsuarios.get(contador).getTipo();
                existe=true;
            }
        
        }
        return existe;
    
    }
     public String[] devolverInformacionConsultada()
    {
        return arregloInformacionConsultada;
    }
    public void modificarUsuario(String arreglo[])
    {
        for(int contador=0;contador<listaDeUsuarios.size();contador++)
        {
            if(listaDeUsuarios.get(contador).getCedula().equals(arreglo[0]))
            {
                listaDeUsuarios.get(contador).setNombreCompleto(arreglo[1]);
                listaDeUsuarios.get(contador).setNombreUsuario(arreglo[2]);
                listaDeUsuarios.get(contador).setContrasenna(arreglo[3]);
                listaDeUsuarios.get(contador).setTipo(arreglo[4]);
            }
        }
    }
    public void eliminarUsuario(String arreglo[])
    {
        for(int contador=0;contador<listaDeUsuarios.size();contador++)
        {
            if(listaDeUsuarios.get(contador).getCedula().equals(arreglo[0]))
            {
                listaDeUsuarios.remove(contador);
            }
        }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }    
    
    ///***Archivos**///
   public ArrayList<Usuario> devolverLista()
   {
       return listaDeUsuarios;
   }
   
   public void leerArchivo(ArrayList<Usuario> lista)
   {
       for (int i = 0; i < lista.size(); i++)
       {
           listaDeUsuarios.add(lista.get(i));
       }
   }
    
  //***Iniciar Sesion***////
   public boolean iniciarSesion(String arreglo[])
   {
       boolean iniciar = false;
       for (int i = 0; i < listaDeUsuarios.size(); i++) {
           if((arreglo[0].equalsIgnoreCase(listaDeUsuarios.get(i).getNombreUsuario()))&&(arreglo[1].equalsIgnoreCase(listaDeUsuarios.get(i).getContrasenna())))
           {
               iniciar=true;
               tipo=listaDeUsuarios.get(i).getTipo();
           }
          
       }
       return iniciar;
   }
   
   public String devolverTipo()
   {
       return tipo;
   }
    
}
