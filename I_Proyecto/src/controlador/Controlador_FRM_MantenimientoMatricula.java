
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ArchivoMatriculas;
import modelo.ArchivoXMLCursos;
import modelo.ArchivoXMLEstudiantes;
import modelo.ArchivosXMLUsuarios;
import modelo.ConexionBD;
import modelo.Matricula;
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosMatricula;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_MantenimientoMatricula;



public class Controlador_FRM_MantenimientoMatricula implements ActionListener
{
    FRM_MantenimientoMatricula frm_MantenimientoMatricula;
    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    boolean encontroEstudiante = false;
    boolean encontroCurso=false;
    public MetodosMatricula metodosMatricula;
     ArchivoMatriculas archivoMatricula;
     public String opcion;
     ConexionBD conexionBD;
     ArrayList<String> listaCantidadDeMatriculas = new ArrayList<String>();
     ArchivoXMLCursos archivoXMLCursos;
     ArchivoXMLEstudiantes archivoXMLEstudiantes;
    public Controlador_FRM_MantenimientoMatricula(FRM_MantenimientoMatricula frm_MantenimientoMatricula,FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes,FRM_MantenimientoCursos frm_MantenimientoCursos) 
    {
        this.frm_MantenimientoMatricula=frm_MantenimientoMatricula;
        this.metodosCursos=frm_MantenimientoCursos.controlador.metodosCursos;
        this.metodosEstudiantes=frm_MantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodosEstudiantes;
        metodosMatricula=new MetodosMatricula(metodosEstudiantes,metodosCursos,frm_MantenimientoMatricula);
        archivoMatricula=new ArchivoMatriculas();
        crearArchivo();
        conexionBD=new ConexionBD(this.frm_MantenimientoMatricula);
        listaCantidadDeMatriculas=conexionBD.consultarCodigoMatriculas();
        
        this.archivoXMLEstudiantes=frm_MantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.archivoXMLEstudiantes;
        this.archivoXMLCursos=frm_MantenimientoCursos.controlador.archivoXMLCursos;
        
    }
    
     public void setOpcion(String opcion)
    {
        this.opcion=opcion;
    }
    
    public String getOpcion()
    {
        return opcion;
    } 
    
   public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equals("Buscar Cedula"))
        {
            if(opcion.equals("Planos"))
            {
                if(metodosEstudiantes.consultarEstudiante(frm_MantenimientoMatricula.devolverCedula()))
                {
                    String arreglo[]=metodosEstudiantes.devolverInformacionConsultada();
                    frm_MantenimientoMatricula.colocarNombreEstudiante(arreglo[1]);
                    encontroEstudiante=true;
                }
                else
                {
                    JOptionPane.showMessageDialog(frm_MantenimientoMatricula, "El estudiante no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
                }
            }
            if(opcion.equals("BD"))
            {
                if(conexionBD.consultarEstudiante(frm_MantenimientoMatricula.devolverCedula()))
                {
                    String arreglo[] = conexionBD.devolverInformacionConsultadaEstudiantes();
                    frm_MantenimientoMatricula.colocarNombreEstudiante(arreglo[1]);
                    encontroEstudiante=true;
                }
                else
                {
                    JOptionPane.showMessageDialog(frm_MantenimientoMatricula, "El estudiante no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
                }
            }
            if(opcion.equalsIgnoreCase("XML"))
            {
                if(archivoXMLEstudiantes.consultarInformacionDelXml(frm_MantenimientoMatricula.devolverCedula()))
                {
                    String arreglo[] = archivoXMLEstudiantes.getArregloInformacion();
                    frm_MantenimientoMatricula.colocarNombreEstudiante(arreglo[1]);
                }
            }
            
        }
        if(e.getActionCommand().equals("Buscar Sigla"))
        {
            if(opcion.equals("Planos"))
            {
                 if(metodosCursos.consultarCurso(frm_MantenimientoMatricula.devolverSigla()))
                {
                    String arreglo[]=metodosCursos.devolverInformacionConsultada();
                    frm_MantenimientoMatricula.colocarNombreCurso(arreglo[1]);
                    encontroCurso=true;
                }
                else
                {
                    JOptionPane.showMessageDialog(frm_MantenimientoMatricula, "El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
                }
            }
             if(opcion.equals("BD"))
             {
                 if(conexionBD.consultarCurso(frm_MantenimientoMatricula.devolverSigla()))
                {
                    String arreglo[]=conexionBD.devolverInformacionConsultadaCursos();
                    frm_MantenimientoMatricula.colocarNombreCurso(arreglo[1]);
                    encontroCurso=true;
                }
                 else
                 {
                     JOptionPane.showMessageDialog(frm_MantenimientoMatricula, "El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
                 }
                     
             }
             if(opcion.equals("XML"))
             {
                 
             }
            
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            if(opcion.equals("Planos"))
             {
                 frm_MantenimientoMatricula.agregarInformacionTabla();
                 frm_MantenimientoMatricula.limpiarSigla();
             }
            if(opcion.equals("BD"))
            {
                frm_MantenimientoMatricula.agregarInformacionTabla();
                frm_MantenimientoMatricula.limpiarSigla();
            }
        }
        if(e.getActionCommand().equals("Finalizar matricula"))
        {
            if(opcion.equals("Planos"))
            {
                String arreglo[]=new String[3];
                for(int contador=0;contador<frm_MantenimientoMatricula.getCantidadFilas();contador++)
                {
                    arreglo[0]=frm_MantenimientoMatricula.devolverCodigo();
                    arreglo[1]=frm_MantenimientoMatricula.devolverDato(contador,1);
                    arreglo[2]=frm_MantenimientoMatricula.devolverDato(contador,3);
                    metodosMatricula.agregarMatricula(arreglo);
                }
                frm_MantenimientoMatricula.colocarCodigo();
                frm_MantenimientoMatricula.resetearVentana();
                encontroEstudiante=false;
                encontroCurso=false;
            }
            if(opcion.equals("BD"))
            {
                String arreglo[]=new String[3];
            
                for(int contador=0;contador<frm_MantenimientoMatricula.getCantidadFilas();contador++)
                {
                    arreglo[0]=frm_MantenimientoMatricula.devolverCodigo();
                    arreglo[1]=frm_MantenimientoMatricula.devolverDato(contador,1);
                    arreglo[2]=frm_MantenimientoMatricula.devolverDato(contador,3);
                    conexionBD.registrarMatriculaDetalle(arreglo);
                }
                conexionBD.registrarMatricula(arreglo);
                listaCantidadDeMatriculas.add(frm_MantenimientoMatricula.devolverCodigo());
                frm_MantenimientoMatricula.colocarCodigoBD();
                frm_MantenimientoMatricula.resetearVentana();
                encontroEstudiante=false;
                encontroCurso=false;
            }
            
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(opcion.equals("Planos"))
            {
                if(metodosMatricula.consultarMatricula(frm_MantenimientoMatricula.devolverCodigo()))
                {
                    frm_MantenimientoMatricula.habilitarOpciones();
                }
                else
                {

                }
            }
            if(opcion.equals("BD"))
            {
                if(conexionBD.consultarMatriculaPrueba(frm_MantenimientoMatricula.devolverCodigo()))
                {
                    frm_MantenimientoMatricula.habilitarOpciones();
                }
                else
                {
                    
                }
            }
            
        
        }
        
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(opcion.equals("Planos"))
            {
                 metodosMatricula.eliminarMatricula(frm_MantenimientoMatricula.getMatriculaSeleccionada());
                frm_MantenimientoMatricula.colocarCodigo();
                frm_MantenimientoMatricula.resetearVentana();
            }
            if(opcion.equals("BD"))
            {
                conexionBD.eliminarMatriculaDetalle(frm_MantenimientoMatricula.getMatriculaSeleccionada());
                frm_MantenimientoMatricula.colocarCodigo();
                frm_MantenimientoMatricula.resetearVentana();
            }
           
           
        }
        
        
        if(e.getActionCommand().equals("Modificar"))
        {
            if(opcion.equals("Planos"))
            {
                frm_MantenimientoMatricula.colocarCodigo();
                frm_MantenimientoMatricula.resetearVentana();
            }
            if(opcion.equals("BD"))
            {
                frm_MantenimientoMatricula.colocarCodigo();
                frm_MantenimientoMatricula.resetearVentana();
            }

        }

        verificarConsultas();
    }
    public void verificarConsultas()
    {
        if(encontroEstudiante && encontroCurso)
        {
            this.frm_MantenimientoMatricula.habilitarAgregar();
        }
    }
    
     public void crearArchivo()
    {
      archivoMatricula.leerEnElArchivo();
        
        if(archivoMatricula.devolverContador()==0)
       {
           archivoMatricula.crearArchivo();
       }
       
       else
       {
           metodosMatricula.leerArchivo(archivoMatricula.leerEnElArchivo());
       }
    }
   
    
    public void escribirInformacionEnElArchivo()
    {
        archivoMatricula.crearArchivo();
        ArrayList <Matricula> lista = metodosMatricula.devolverLista();
        
        for (int i = 0; i < lista.size(); i++) 
        {
               archivoMatricula.escribirEnElArchivo(lista.get(i));
            }
        
    }
    
    public String devolverCodigoBD()
    {
        String codigo= "0000";
      
            if(listaCantidadDeMatriculas.size()==0)
            {
                codigo+=1;
                System.out.println("no hay matriculas en bd");            }
            else
            {
                int numero=Integer.parseInt(listaCantidadDeMatriculas.get(listaCantidadDeMatriculas.size()-1));
                numero++;
                codigo="0000"+numero;
            }
            codigo=codigo.substring(codigo.length()-5, codigo.length());
            
        return codigo; 
    }
}
