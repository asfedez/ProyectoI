
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ArchivoMatriculas;
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
    public Controlador_FRM_MantenimientoMatricula(FRM_MantenimientoMatricula frm_MantenimientoMatricula,FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes,FRM_MantenimientoCursos frm_MantenimientoCursos) 
    {
        this.frm_MantenimientoMatricula=frm_MantenimientoMatricula;
        this.metodosCursos=frm_MantenimientoCursos.controlador.metodosCursos;
        this.metodosEstudiantes=frm_MantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodosEstudiantes;
        metodosMatricula=new MetodosMatricula(metodosEstudiantes,metodosCursos,frm_MantenimientoMatricula);
        archivoMatricula=new ArchivoMatriculas();
    }
    
    
    
    
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equalsIgnoreCase("Buscar Cedula"))
        {
             if(metodosEstudiantes.consultarEstudiante(frm_MantenimientoMatricula.devolverInformacionIngresada()[0]))
            {
                String arreglo[]=metodosEstudiantes.devolverInformacionConsultada();
                frm_MantenimientoMatricula.colocarNombreEstudiante(arreglo[1]);
                encontroEstudiante=true;
            }
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoMatricula, "El estudiante no se encuentra, verifique en Estudiantes");
                
            }
        }
         if(evento.getActionCommand().equalsIgnoreCase("Buscar Sigla"))
        {
            if(metodosCursos.consultarCurso(frm_MantenimientoMatricula.devolverInformacionIngresada()[1]))
            {
                String arreglo[]=metodosCursos.devolverInformacionConsultada();
                frm_MantenimientoMatricula.colocarNombreCurso(arreglo[1]);
                encontroCurso=true;
            }
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoMatricula, "El curso no se encuentra, verifique en Cursos");
            }
        }
               
        
        if(evento.getActionCommand().equals("Agregar"))
        {
            frm_MantenimientoMatricula.agregarInformacionTabla();
            frm_MantenimientoMatricula.limpiarSigla();
        }
        if(evento.getActionCommand().equals("Finalizar matricula"))
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
            frm_MantenimientoMatricula.inicializarGUI();
            encontroEstudiante=false;
            encontroCurso=false;
                 
        }
        if(evento.getActionCommand().equals("Consultar"))
        {
            if(metodosMatricula.consultarMatricula(frm_MantenimientoMatricula.devolverCodigo()))
            {
                frm_MantenimientoMatricula.habilitarEdicion();
            }
            else
            {
            
            }
        }
        
        if(evento.getActionCommand().equals("Eliminar"))
        {
            metodosMatricula.eliminarMatricula(frm_MantenimientoMatricula.getMatriculaSeleccionada());
            frm_MantenimientoMatricula.colocarCodigo();
            frm_MantenimientoMatricula.inicializarGUI();
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
    
    
}
