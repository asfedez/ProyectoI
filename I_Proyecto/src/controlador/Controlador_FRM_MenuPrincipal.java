
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_MenuPrincipal;

public class Controlador_FRM_MenuPrincipal implements ActionListener
{
    FRM_MenuPrincipal frm_MenuPrincipal;
    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;

    public Controlador_FRM_MenuPrincipal(FRM_MenuPrincipal frm_MenuPrincipal) 
    {
        this.frm_MenuPrincipal = frm_MenuPrincipal;
        frm_MantenimientoEstudiantes= new FRM_MantenimientoEstudiantes();
    }
    
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equalsIgnoreCase("Estudiantes"))
        {
            frm_MantenimientoEstudiantes.setVisible(true);
        }
        if(evento.getActionCommand().equalsIgnoreCase("Cursos"))
        {
            
        }
        if(evento.getActionCommand().equalsIgnoreCase("Matricula"))
        {
            
        }
        if(evento.getActionCommand().equalsIgnoreCase("Usuarios"))
        {
            
        }
    }
}
