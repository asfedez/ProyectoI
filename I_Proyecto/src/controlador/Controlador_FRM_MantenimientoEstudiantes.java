/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ArchivoEstudiantes;
import modelo.ArchivoXMLEstudiantes;
import modelo.ConexionBD;
import modelo.Estudiante;
import modelo.MetodosEstudiantes;
import vista.FRM_MantenimientoEstudiantes;

/**
 *
 * @author Usuario
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener
{
    MetodosEstudiantes metodosEstudiantes;
    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    ArchivoEstudiantes archivoEstudiantes;
    ArchivoXMLEstudiantes archivoXMLEstudiantes;
    ConexionBD conexionBD;
    String opcion;
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes) 
    {
        this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
        metodosEstudiantes=new MetodosEstudiantes();
        archivoEstudiantes=new ArchivoEstudiantes();
        archivoXMLEstudiantes = new ArchivoXMLEstudiantes(frm_MantenimientoEstudiantes);
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
        if(evento.getActionCommand().equalsIgnoreCase("Consultar"))
        {
            consultar();
        }
        if(evento.getActionCommand().equalsIgnoreCase("Agregar"))
        {
            if(opcion.equalsIgnoreCase("Planos"))
            {
                metodosEstudiantes.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacionIngresada());
                frm_MantenimientoEstudiantes.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "Estudiante agregado correctamente en archivos planos");
            }
            if(opcion.equalsIgnoreCase("BD"))
            {
                conexionBD.registrarEstudiante(frm_MantenimientoEstudiantes.devolverInformacionIngresada());
                frm_MantenimientoEstudiantes.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "Estudiante agregado correctamente en la base de datos");
            }
            if(opcion.equalsIgnoreCase("XML"))
            {
                archivoXMLEstudiantes.guardarEnXML(frm_MantenimientoEstudiantes.devolverInformacionIngresada());
                frm_MantenimientoEstudiantes.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "Estudiante agregado correctamente en archivos XML");
            }
        }
        if(evento.getActionCommand().equalsIgnoreCase("Modificar"))
        {
            if(opcion.equalsIgnoreCase("Planos"))
            {
                metodosEstudiantes.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacionIngresada());
                frm_MantenimientoEstudiantes.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "Estudiante modificado correctamente en archivos planos");
            }
            if(opcion.equalsIgnoreCase("BD"))
            {
                conexionBD.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacionIngresada());
                frm_MantenimientoEstudiantes.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "Estudiante modificado correctamente en la base de datos");
            }
            if(opcion.equalsIgnoreCase("XML"))
            {
                archivoXMLEstudiantes.modificarInformacionDelXml(frm_MantenimientoEstudiantes.devolverInformacionIngresada());
                frm_MantenimientoEstudiantes.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "Estudiante modificado correctamente en archivos XML");
            }
           
        }
        if(evento.getActionCommand().equalsIgnoreCase("Eliminar"))
        {
            if(opcion.equalsIgnoreCase("Planos"))
            {
                metodosEstudiantes.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacionIngresada());
                frm_MantenimientoEstudiantes.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "Estudiante eliminado de archivos planos");
                
            }
            
            if(opcion.equalsIgnoreCase("BD"))
            {
                conexionBD.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacionIngresada()[0]);
                frm_MantenimientoEstudiantes.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "Estudiante eliminado de la base de datos");
            }
            if(opcion.equalsIgnoreCase("XML"))
            {
                archivoXMLEstudiantes.eliminarInformacionDelXml(frm_MantenimientoEstudiantes.devolverInformacionIngresada()[0]);
                frm_MantenimientoEstudiantes.inicializarGUI();
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "Estudiante eliminado de archivos XML");
            }
        }
    }
    public void consultar()
    {
        if(opcion.equalsIgnoreCase("Planos"))
        {
            if(metodosEstudiantes.consultarEstudiante(frm_MantenimientoEstudiantes.devolverInformacionIngresada()[0]))
            {
                frm_MantenimientoEstudiantes.mostrarInformacion(metodosEstudiantes.devolverInformacionConsultada());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "Estudiante no encontrado en archivos planos");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            } 
        }
        if(opcion.equalsIgnoreCase("BD"))
        {
            if(conexionBD.consultarEstudiante(frm_MantenimientoEstudiantes.devolverInformacionIngresada()[0]))
            {
                frm_MantenimientoEstudiantes.mostrarInformacion(conexionBD.devolverInformacionConsultadaEstudiantes());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "Estudiante no encontrado en la base de datos");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }
        }
        if(opcion.equalsIgnoreCase("XML"))
        {
            if(archivoXMLEstudiantes.consultarInformacionDelXml(frm_MantenimientoEstudiantes.devolverInformacionIngresada()[0]))
            {
                frm_MantenimientoEstudiantes.mostrarInformacion(archivoXMLEstudiantes.getArregloInformacion());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes,"Estudiante no encontrado en archivos XML");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            } 
        }
    }
    
    
    ///******Archivos planos*****/////////
    public void crearArchivo()
    {
      archivoEstudiantes.leerEnElArchivo();
        
        if(archivoEstudiantes.devolverContador()==0)
       {
           archivoEstudiantes.crearArchivo();
       }
       
       else
       {
           metodosEstudiantes.leerArchivo(archivoEstudiantes.leerEnElArchivo());
       }
    }
   
    
    public void escribirInformacionEnElArchivo()
    {
        archivoEstudiantes.crearArchivo();
        ArrayList <Estudiante> lista = metodosEstudiantes.devolverLista();
        
        for (int i = 0; i < lista.size(); i++) 
        {
               archivoEstudiantes.escribirEnElArchivo(lista.get(i));
            }
        
    }
    
}
