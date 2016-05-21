/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosUsuarios;
import vista.FRM_MantenimientoUsuarios;


public class Controlador_FRM_MantenimientoUsuarios implements ActionListener
{
    FRM_MantenimientoUsuarios frm_MantenimientoUsuarios;
    MetodosUsuarios metodosUsuarios;
    
    public Controlador_FRM_MantenimientoUsuarios()
    {
        frm_MantenimientoUsuarios = new FRM_MantenimientoUsuarios();
        metodosUsuarios = new MetodosUsuarios();
    }
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            frm_MantenimientoUsuarios.habilitarEdicion();
            metodosUsuarios.agregarUsuario(frm_MantenimientoUsuarios.devolverInformacionIngresada());
            frm_MantenimientoUsuarios.mostrarMensaje("El curso fue registrado de forma correcta");
            frm_MantenimientoUsuarios.inicializarGUI();
        }
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            buscar();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
            metodosUsuarios.modificarUsuario(frm_MantenimientoUsuarios.devolverInformacionIngresada());
            frm_MantenimientoUsuarios.mostrarMensaje("El curso fue modificado de forma correcta.");
            frm_MantenimientoUsuarios.inicializarGUI();
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            metodosUsuarios.eliminarUsuario(frm_MantenimientoUsuarios.devolverInformacionIngresada());
            frm_MantenimientoUsuarios.mostrarMensaje("El curso fue eliminado de forma correcta.");
            frm_MantenimientoUsuarios.inicializarGUI();
        }
    
    }
    
    public void buscar()
    {
        if(metodosUsuarios.consultarUsuario(frm_MantenimientoUsuarios.devolverInformacionIngresada()[0]))
            {
                frm_MantenimientoUsuarios.mostrarInformacion(metodosUsuarios.devolverInformacionConsultada());
                frm_MantenimientoUsuarios.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoUsuarios.mostrarMensaje("La cedula buscada no se encuentra.");
                frm_MantenimientoUsuarios.habilitarAgregar();
            }
    
    }
}
