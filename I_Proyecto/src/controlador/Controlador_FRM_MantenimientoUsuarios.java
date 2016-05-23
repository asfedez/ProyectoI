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
import modelo.ArchivoUsuarios;
import modelo.ArchivosXMLUsuarios;
import modelo.ConexionBD;
import modelo.Estudiante;
import modelo.MetodosUsuarios;
import modelo.Usuario;
import vista.FRM_MantenimientoUsuarios;


public class Controlador_FRM_MantenimientoUsuarios implements ActionListener
{
    FRM_MantenimientoUsuarios frm_MantenimientoUsuarios;
    MetodosUsuarios metodosUsuarios;
    ArchivoUsuarios archivoUsuarios;
    ArchivosXMLUsuarios archivoXMLUsuarios;
    ConexionBD conexionBD;
    String opcion;
    boolean creado=false;
    int contadorDeXML=0;
    public Controlador_FRM_MantenimientoUsuarios(FRM_MantenimientoUsuarios frm_MantenimientoUsuarios)
    {
        this.frm_MantenimientoUsuarios = frm_MantenimientoUsuarios;
        metodosUsuarios = new MetodosUsuarios();
        archivoUsuarios=new ArchivoUsuarios();
        archivoXMLUsuarios=new ArchivosXMLUsuarios(frm_MantenimientoUsuarios);
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
            if(frm_MantenimientoUsuarios.confirmarContrasena())
            {
                if(opcion.equalsIgnoreCase("Planos"))
                {
                    metodosUsuarios.agregarUsuario(frm_MantenimientoUsuarios.devolverInformacionIngresada());
                    frm_MantenimientoUsuarios.inicializarGUI();
                    JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Estudiante agregado correctamente en archivos planos");
                }
            }
          
                        
            if(frm_MantenimientoUsuarios.confirmarContrasena())
            {
                if(opcion.equalsIgnoreCase("BD"))
                {
                    conexionBD.registrarUsuarios(frm_MantenimientoUsuarios.devolverInformacionIngresada());
                    frm_MantenimientoUsuarios.inicializarGUI();
                    JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Estudiante agregado correctamente en la base de datos");
                }
            
            }
           
            if(frm_MantenimientoUsuarios.confirmarContrasena())
            {
                if(opcion.equalsIgnoreCase("XML"))
               {
                   archivoXMLUsuarios.guardarEnXML(frm_MantenimientoUsuarios.devolverInformacionIngresada());
                   frm_MantenimientoUsuarios.inicializarGUI();
                   JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Estudiante agregado correctamente en archivos XML");
               }
            }
            else
             {
                 JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Contraseñas no coinciden");
             }
            
           
        }
        
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            buscar();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
            if(frm_MantenimientoUsuarios.confirmarContrasena())
            {
                if(opcion.equalsIgnoreCase("Planos"))
                {
                    metodosUsuarios.modificarUsuario(frm_MantenimientoUsuarios.devolverInformacionIngresada());
                    frm_MantenimientoUsuarios.inicializarGUI();
                    JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Estudiante modificado correctamente en archivos planos");
                }
         
            }    
            if(frm_MantenimientoUsuarios.confirmarContrasena())
            {
                if(opcion.equalsIgnoreCase("BD"))
               {
                   conexionBD.modificarUsuario(frm_MantenimientoUsuarios.devolverInformacionIngresada());
                   frm_MantenimientoUsuarios.inicializarGUI();
                   JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Estudiante modificado correctamente en la base de datos");
               }

            }
            if(frm_MantenimientoUsuarios.confirmarContrasena())
            {
                if(opcion.equalsIgnoreCase("XML"))
                {
                    archivoXMLUsuarios.modificarInformacionDelXml(frm_MantenimientoUsuarios.devolverInformacionIngresada());
                    frm_MantenimientoUsuarios.inicializarGUI();
                    JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Estudiante modificado correctamente en archivos XML");
                }
            }
            
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Contraseñas no coinciden");
            }
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            if(frm_MantenimientoUsuarios.confirmarContrasena())
            {
                if(opcion.equalsIgnoreCase("Planos"))
                {
                    metodosUsuarios.eliminarUsuario(frm_MantenimientoUsuarios.devolverInformacionIngresada());
                    frm_MantenimientoUsuarios.inicializarGUI();
                    JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Estudiante eliminado de archivos planos");

                }
            }
           
            if(frm_MantenimientoUsuarios.confirmarContrasena())
            {
                if(opcion.equalsIgnoreCase("BD"))
                {
                    conexionBD.eliminarUsuario(frm_MantenimientoUsuarios.devolverInformacionIngresada()[0]);
                    frm_MantenimientoUsuarios.inicializarGUI();
                    JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Estudiante eliminado de la base de datos");
                }
            }
             
            if(frm_MantenimientoUsuarios.confirmarContrasena())
            {
                if(opcion.equalsIgnoreCase("XML"))
                {
                    archivoXMLUsuarios.eliminarInformacionDelXml(frm_MantenimientoUsuarios.devolverInformacionIngresada()[0]);
                    frm_MantenimientoUsuarios.inicializarGUI();
                    JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Estudiante eliminado de archivos XML");
                }
            }
             else
             {
                 JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Contraseñas no coinciden");
             } 
        }
    
    }
    
    public void buscar()
    {
        if(opcion.equalsIgnoreCase("Planos"))
        {
            if(metodosUsuarios.consultarUsuario(frm_MantenimientoUsuarios.devolverInformacionIngresada()[0]))
            {
                frm_MantenimientoUsuarios.mostrarInformacion(metodosUsuarios.devolverInformacionConsultada());
                frm_MantenimientoUsuarios.habilitarEdicion();
            }
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Estudiante no encontrado en archivos planos");
                frm_MantenimientoUsuarios.habilitarAgregar();
            } 
        }
        if(opcion.equalsIgnoreCase("BD"))
        {
            if(conexionBD.consultarUsuario(frm_MantenimientoUsuarios.devolverInformacionIngresada()[0]))
            {
                frm_MantenimientoUsuarios.mostrarInformacion(conexionBD.devolverInformacionConsultadaUsuarios());
                frm_MantenimientoUsuarios.habilitarEdicion();
            }
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoUsuarios, "Estudiante no encontrado en la base de datos");
                frm_MantenimientoUsuarios.habilitarAgregar();
            }
        }
        if(opcion.equalsIgnoreCase("XML"))
        {
            if(archivoXMLUsuarios.consultarInformacionDelXml(frm_MantenimientoUsuarios.devolverInformacionIngresada()[0]))
            {
                frm_MantenimientoUsuarios.mostrarInformacion(archivoXMLUsuarios.getArregloInformacion());
                frm_MantenimientoUsuarios.habilitarEdicion();
            }
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoUsuarios,"Estudiante no encontrado en archivos XML");
                frm_MantenimientoUsuarios.habilitarAgregar();
            } 
        }
    }
    
   
    
      ///******Archivos planos*****/////////
    public void crearArchivo()
    {
      archivoUsuarios.leerEnElArchivo();
        
        if(archivoUsuarios.devolverContador()==0)
       {
           archivoUsuarios.crearArchivo();
       }
       
       else
       {
           metodosUsuarios.leerArchivo(archivoUsuarios.leerEnElArchivo());
       }
    }
   
    
    public void escribirInformacionEnElArchivo()
    {
        archivoUsuarios.crearArchivo();
        ArrayList <Usuario> lista = metodosUsuarios.devolverLista();
        
        for (int i = 0; i < lista.size(); i++) 
        {
               archivoUsuarios.escribirEnElArchivo(lista.get(i));
            }
        
    }
     public boolean iniciarSesion(String arreglo[])
    {
       return metodosUsuarios.iniciarSesion(arreglo);
    }
}
