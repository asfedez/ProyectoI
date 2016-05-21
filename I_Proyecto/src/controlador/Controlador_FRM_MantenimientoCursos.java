package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.MetodosCursos;
import vista.FRM_MantenimientoCursos;


public class Controlador_FRM_MantenimientoCursos implements ActionListener
{
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    MetodosCursos metodosCursos;
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_MantenimientoCursos)
    {
        this.frm_MantenimientoCursos=frm_MantenimientoCursos;
        metodosCursos = new MetodosCursos();

    }
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            frm_MantenimientoCursos.habilitarEdicion();
            metodosCursos.agregarCurso(frm_MantenimientoCursos.devolverInformacionIngresada());
            frm_MantenimientoCursos.mostrarMensaje("El curso fue registrado de forma correcta");
            frm_MantenimientoCursos.inicializarGUI();
        }
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            buscar();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
             metodosCursos.modificarCurso(frm_MantenimientoCursos.devolverInformacionIngresada());
            frm_MantenimientoCursos.mostrarMensaje("El curso fue modificado de forma correcta.");
            frm_MantenimientoCursos.inicializarGUI();
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            metodosCursos.eliminarCurso(frm_MantenimientoCursos.devolverInformacionIngresada());
            frm_MantenimientoCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
            frm_MantenimientoCursos.inicializarGUI();
        }
    
    }
  public void buscar()
    {
        if(metodosCursos.consultarCurso(frm_MantenimientoCursos.devolverInformacionIngresada()))
            {
                frm_MantenimientoCursos.mostrarInformacion(metodosCursos.devolverInformacionConsultada());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra.");
                frm_MantenimientoCursos.habilitarAgregar();
            }
    
    }
}
