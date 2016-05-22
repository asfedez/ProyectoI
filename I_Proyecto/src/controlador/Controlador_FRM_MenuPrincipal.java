
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import modelo.Usuario;
import vista.FRM_Login;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_MantenimientoMatricula;
import vista.FRM_MantenimientoUsuarios;
import vista.FRM_MenuPrincipal;

public class Controlador_FRM_MenuPrincipal implements ActionListener
{
    FRM_MenuPrincipal frm_MenuPrincipal;
    public FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    public FRM_MantenimientoCursos frm_MantenimientoCursos;
    public FRM_MantenimientoMatricula frm_MantenimientoMatricula;
    public FRM_MantenimientoUsuarios frm_MantenimientoUsuarios;
    ConexionBD conexionBD;
    String opcion;
    FRM_Login frm_Login;

    public Controlador_FRM_MenuPrincipal(FRM_MenuPrincipal frm_MenuPrincipal) 
    {
        this.frm_MenuPrincipal = frm_MenuPrincipal;
        frm_MantenimientoUsuarios = new FRM_MantenimientoUsuarios();
        frm_MantenimientoCursos=new FRM_MantenimientoCursos();
        frm_MantenimientoEstudiantes= new FRM_MantenimientoEstudiantes();
        frm_MantenimientoMatricula= new FRM_MantenimientoMatricula(frm_MantenimientoEstudiantes,frm_MantenimientoCursos);
        conexionBD=new ConexionBD();
        conexionBD.realizarConexion();
        frm_Login=new FRM_Login();
        mostrarIniciarSesion();
        frm_Login.agregarEventos(this);
    }
    
    public void setOpcion(String opcion)
    {
        this.opcion=opcion;
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equalsIgnoreCase("Estudiantes"))
        {
            frm_MantenimientoEstudiantes.setVisible(true);
            frm_MantenimientoEstudiantes.establecerOpcionAlControlador(opcion);
        }
        if(evento.getActionCommand().equalsIgnoreCase("Cursos"))
        {
            frm_MantenimientoCursos.setVisible(true);
            frm_MantenimientoCursos.establecerOpcionAlControlador(opcion);
        }
        if(evento.getActionCommand().equalsIgnoreCase("Matricula"))
        {
            frm_MantenimientoMatricula.setVisible(true);
              
            frm_MantenimientoMatricula.establecerOpcionAlControlador(opcion);
            if(opcion.equalsIgnoreCase("Planos"))
                frm_MantenimientoMatricula.colocarCodigo();
            if(opcion.equalsIgnoreCase("BD"))
                frm_MantenimientoMatricula.colocarCodigoBD();
        }
        if(evento.getActionCommand().equalsIgnoreCase("Usuarios"))
        {
            frm_MantenimientoUsuarios.setVisible(true);
            frm_MantenimientoUsuarios.establecerOpcionAlControlador(opcion);
        }
        
         if(evento.getActionCommand().equalsIgnoreCase("Iniciar sesión"))
         {
             iniciarSesion();
         }
         if(evento.getActionCommand().equalsIgnoreCase("Cancelar"))
         {
             System.exit(0);
         }
    }
    
     public void mostrarIniciarSesion()
    {
        
       ArrayList<Usuario>lista=frm_MantenimientoUsuarios.controlador.archivoUsuarios.leerEnElArchivo();
         if(frm_MantenimientoUsuarios.controlador.archivoUsuarios.devolverContador()==0)
        { 
            frm_MenuPrincipal.setVisible(true);
        }
        else
        {
            frm_Login.setVisible(true); 
        }
    }
    
    public void iniciarSesion()
    {
        if(frm_MantenimientoUsuarios.controlador.iniciarSesion(frm_Login.devolverInformacionDeInicioDeSesion()))
        {
            frm_MenuPrincipal.setVisible(true);
            if(frm_MantenimientoUsuarios.controlador.metodosUsuarios.devolverTipo().equalsIgnoreCase("Usuario"))
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
    
    
    
    
}
