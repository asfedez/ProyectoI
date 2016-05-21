/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
    String opcion;
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes) 
    {
        this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
        metodosEstudiantes=new MetodosEstudiantes();
    }
    
    public void setOpcion(String opcion)
    {
        this.opcion=opcion;
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equalsIgnoreCase("Consultar"))
        {
            consultar();
        }
        if(evento.getActionCommand().equalsIgnoreCase("Agregar"))
        {
            metodosEstudiantes.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacionIngresada());
        }
        if(evento.getActionCommand().equalsIgnoreCase("Modificar"))
        {
            
        }
        if(evento.getActionCommand().equalsIgnoreCase("Eliminar"))
        {
            
        }
    }
    public void consultar()
    {
        if(opcion.equalsIgnoreCase("Planos"))
        {
            if(metodosEstudiantes.consultarEstudiante(frm_MantenimientoEstudiantes.devolverInformacionIngresada()[0]))
            {
                frm_MantenimientoEstudiantes.mostrarInformacion(metodosEstudiantes.devolverInformacionConsultada());
            }
            else
            {
                JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "Estudiante no encontrado");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            } 
        }
        else
        {
            JOptionPane.showMessageDialog(frm_MantenimientoEstudiantes, "otraOpcion");
        }
          
      
     
  
    }
    
}
