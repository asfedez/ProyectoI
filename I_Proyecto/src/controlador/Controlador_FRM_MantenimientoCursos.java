package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ArchivoCursos;
import modelo.ArchivoXMLCursos;
import modelo.ConexionBD;
import modelo.Curso;
import modelo.MetodosCursos;
import vista.FRM_MantenimientoCursos;


public class Controlador_FRM_MantenimientoCursos implements ActionListener
{
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    public MetodosCursos metodosCursos;
    ArchivoCursos archivoCursos;
    public ArchivoXMLCursos archivoXMLCursos;
    ConexionBD conexionBD;
    String opcion;
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_MantenimientoCursos)
    {
        this.frm_MantenimientoCursos=frm_MantenimientoCursos;
        metodosCursos = new MetodosCursos();
        archivoCursos=new ArchivoCursos();
        archivoXMLCursos = new ArchivoXMLCursos(frm_MantenimientoCursos);
        conexionBD=new ConexionBD();
        crearArchivo();

    }
    
    public void setOpcion(String opcion)
    {
        this.opcion=opcion;
    }
    
    public String getOpcion()
    {
        return opcion;
    }
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            if(opcion.equalsIgnoreCase("Planos"))
            {
                metodosCursos.agregarCurso(frm_MantenimientoCursos.devolverInformacionIngresada());
                frm_MantenimientoCursos.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoCursos, "Curso agregado correctamente en archivos planos");
            }
            if(opcion.equalsIgnoreCase("BD"))
            {
                conexionBD.registrarCurso(frm_MantenimientoCursos.devolverInformacionIngresada());
                frm_MantenimientoCursos.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoCursos, "Curso agregado correctamente en la base de datos");
            }
            if(opcion.equalsIgnoreCase("XML"))
            {
                archivoXMLCursos.guardarEnXML(frm_MantenimientoCursos.devolverInformacionIngresada());
                frm_MantenimientoCursos.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoCursos, "Curso agregado correctamente en archivos XML");
            }
        }
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            buscar();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
             if(opcion.equalsIgnoreCase("Planos"))
            {
                metodosCursos.modificarCurso(frm_MantenimientoCursos.devolverInformacionIngresada());
                frm_MantenimientoCursos.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoCursos, "Curso modificado correctamente en archivos planos");
            }
            if(opcion.equalsIgnoreCase("BD"))
            {
                conexionBD.modificarCurso(frm_MantenimientoCursos.devolverInformacionIngresada());
                frm_MantenimientoCursos.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoCursos, "Curso modificado correctamente en la base de datos");
            }
            if(opcion.equalsIgnoreCase("XML"))
            {
                archivoXMLCursos.modificarInformacionDelXml(frm_MantenimientoCursos.devolverInformacionIngresada());
                frm_MantenimientoCursos.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoCursos, "Curso modificado correctamente en archivos XML");
            }
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            if(opcion.equalsIgnoreCase("Planos"))
            {
                metodosCursos.eliminarCurso(frm_MantenimientoCursos.devolverInformacionIngresada());
                frm_MantenimientoCursos.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoCursos, "Curso eliminado de archivos planos");
                
            }
            
            if(opcion.equalsIgnoreCase("BD"))
            {
                conexionBD.eliminarCurso(frm_MantenimientoCursos.devolverInformacionIngresada()[0]);
                frm_MantenimientoCursos.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoCursos, "Curso eliminado de la base de datos");
            }
            if(opcion.equalsIgnoreCase("XML"))
            {
                archivoXMLCursos.eliminarInformacionDelXml(frm_MantenimientoCursos.devolverInformacionIngresada()[0]);
                frm_MantenimientoCursos.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoCursos, "Curso eliminado de archivos XML");
            }
        }
    
    }
  public void buscar()
    {
         if(opcion.equalsIgnoreCase("Planos"))
        {
            if(metodosCursos.consultarCurso(frm_MantenimientoCursos.devolverInformacionIngresada()[0]))
            {
                frm_MantenimientoCursos.mostrarInformacion(metodosCursos.devolverInformacionConsultada());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoCursos, "Curso no encontrado en archivos planos");
                frm_MantenimientoCursos.habilitarAgregar();
            } 
        }
        if(opcion.equalsIgnoreCase("BD"))
        {
            if(conexionBD.consultarCurso(frm_MantenimientoCursos.devolverInformacionIngresada()[0]))
            {
                frm_MantenimientoCursos.mostrarInformacion(conexionBD.devolverInformacionConsultadaCursos());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoCursos, "Curso no encontrado en la base de datos");
                frm_MantenimientoCursos.habilitarAgregar();
            }
        }
        if(opcion.equalsIgnoreCase("XML"))
        {
            if(archivoXMLCursos.consultarInformacionDelXml(frm_MantenimientoCursos.devolverInformacionIngresada()[0]))
            {
                frm_MantenimientoCursos.mostrarInformacion(archivoXMLCursos.getArregloInformacion());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoCursos,"Curso no encontrado en archivos XML");
                frm_MantenimientoCursos.habilitarAgregar();
            } 
        }
    }
  
        ///******Archivos planos*****/////////
    public void crearArchivo()
    {
      archivoCursos.leerEnElArchivo();
        
        if(archivoCursos.devolverContador()==0)
       {
           archivoCursos.crearArchivo();
       }
       
       else
       {
           metodosCursos.leerArchivo(archivoCursos.leerEnElArchivo());
       }
    }
   
    
    public void escribirInformacionEnElArchivo()
    {
        archivoCursos.crearArchivo();
        ArrayList <Curso> lista = metodosCursos.devolverLista();
        
        for (int i = 0; i < lista.size(); i++) 
        {
               archivoCursos.escribirEnElArchivo(lista.get(i));
            }
        
    }
}
