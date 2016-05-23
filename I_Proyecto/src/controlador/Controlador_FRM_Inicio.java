
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import modelo.Usuario;
import vista.FRM_Inicio;
import vista.FRM_Login;
import vista.FRM_MantenimientoUsuarios;
import vista.FRM_MenuPrincipal;

public class Controlador_FRM_Inicio implements ItemListener, ActionListener{
    
    FRM_Inicio frm_Inicio;
    FRM_MenuPrincipal frm_MenuPrincipal;
    Controlador_FRM_MenuPrincipal controlador_FRM_MenuPrincipal;
    ConexionBD conexionBD;
    FRM_MantenimientoUsuarios frm_MantenimientoUsuarios;
    FRM_Login frm_Login;
    String opcion;
    public Controlador_FRM_Inicio(FRM_Inicio frm_Inicio) 
    {
        //conexionBD=new ConexionBD();
        frm_MenuPrincipal=new FRM_MenuPrincipal();
        this.frm_Inicio=frm_Inicio;
        controlador_FRM_MenuPrincipal= new Controlador_FRM_MenuPrincipal(frm_MenuPrincipal);
        this.frm_MantenimientoUsuarios=frm_MenuPrincipal.controlador_FRM_MenuPrincipal.frm_MantenimientoUsuarios;
        frm_Login=new FRM_Login();
        frm_Login.agregarEventos(this);
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
        if(evento.getActionCommand().equalsIgnoreCase("Iniciar"))
         {
             if(getOpcion().equals("Planos"))
                iniciarSesionArchivosPlanos();
             
             if(getOpcion().equals("BD"))
                 iniciarSesionBD();
             
             if(getOpcion().equals("XML"))
                 iniciarSesionXML();
         }
         if(evento.getActionCommand().equalsIgnoreCase("Cancelar"))
         {
             frm_Login.hide();
         }
    }
    
    public void itemStateChanged(ItemEvent e)
    {
       if(e.getItem()==frm_Inicio.panel_Inicio1.radio_Planos)
       {
           
           if(e.getStateChange()==1)
           {
               frm_Inicio.setOpcion("Planos");
               setOpcion("Planos");
               frm_MenuPrincipal.controlador_FRM_MenuPrincipal.setOpcion(frm_Inicio.getOpcion());
               
               ArrayList<Usuario>lista=frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.archivoUsuarios.leerEnElArchivo();
                if(frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.archivoUsuarios.devolverContador()==0)
               { 
                   frm_MenuPrincipal.setVisible(true);
               }
               else
               {
                   frm_Login.setVisible(true); 
               }
           }
           
       }
       if(e.getItem()==frm_Inicio.panel_Inicio1.radio_XML)
       {
           if(e.getStateChange()==1)
           {
               frm_Inicio.setOpcion("XML");
               setOpcion("XML");
              frm_MenuPrincipal.controlador_FRM_MenuPrincipal.setOpcion(frm_Inicio.getOpcion());
              if(frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.archivoXMLUsuarios.getExiste())
              {
                  frm_Login.setVisible(true);
              }
              else
              {
                  frm_MenuPrincipal.setVisible(true);
              }
           }
       }
       if(e.getItem()==frm_Inicio.panel_Inicio1.radio_BD)
       {
           if(e.getStateChange()==1)
           {
               frm_Inicio.setOpcion("BD");
               setOpcion("BD");
               frm_MenuPrincipal.controlador_FRM_MenuPrincipal.setOpcion(frm_Inicio.getOpcion());
               if(frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.conexionBD.consultarUsuarios())
                { 
                    frm_MenuPrincipal.setVisible(true);
                }
                else
                {
                    frm_Login.setVisible(true); 
                }
           }
       }
       
    }
    
    public void iniciarSesionArchivosPlanos()
    {
        if(frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.iniciarSesion(frm_Login.devolverInformacionDeInicioDeSesion()))
        {
            frm_MenuPrincipal.setVisible(true);
            if(frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.metodosUsuarios.devolverTipo().equalsIgnoreCase("Usuario"))
            {
                frm_MenuPrincipal.opcionesUsuario();
            }
            frm_Login.hide();
        }
        else
        {
            JOptionPane.showMessageDialog(frm_Login, "Contraseña o usuario incorrecto");
        }
        
    }
    
     public void iniciarSesionBD()
    {
        if(frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.conexionBD.iniciarSesion(frm_Login.devolverInformacionDeInicioDeSesion()))
        {
            frm_MenuPrincipal.setVisible(true);
            if(frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.conexionBD.devolverTipo().equalsIgnoreCase("Usuario"))
            {
                //frm_ventanaPrincipal.opcionesUsuario();
            }
            frm_Login.hide();
        }
        else
        {
            JOptionPane.showMessageDialog(frm_Login, "Contraseña o usuario incorrecto");
        }
        
    }
    
     public void iniciarSesionXML()
     {
         if(frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.archivoXMLUsuarios.IniciarSesion(frm_Login.devolverInformacionDeInicioDeSesion()))
         {
             frm_MenuPrincipal.setVisible(true);
         }
         else 
         {
              JOptionPane.showMessageDialog(frm_Login, "Contraseña o usuario incorrecto");
         }
     }
   

}
