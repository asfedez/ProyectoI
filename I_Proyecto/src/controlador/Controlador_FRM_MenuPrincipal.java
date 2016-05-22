
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
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

    public Controlador_FRM_MenuPrincipal(FRM_MenuPrincipal frm_MenuPrincipal) 
    {
        this.frm_MenuPrincipal = frm_MenuPrincipal;
        frm_MantenimientoUsuarios = new FRM_MantenimientoUsuarios();
        frm_MantenimientoCursos=new FRM_MantenimientoCursos();
        frm_MantenimientoEstudiantes= new FRM_MantenimientoEstudiantes();
        frm_MantenimientoMatricula= new FRM_MantenimientoMatricula(frm_MantenimientoEstudiantes,frm_MantenimientoCursos);
        conexionBD=new ConexionBD();
        conexionBD.realizarConexion();
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
        }
        if(evento.getActionCommand().equalsIgnoreCase("Usuarios"))
        {
            frm_MantenimientoUsuarios.setVisible(true);
            frm_MantenimientoUsuarios.establecerOpcionAlControlador(opcion);
        }
    }
}
