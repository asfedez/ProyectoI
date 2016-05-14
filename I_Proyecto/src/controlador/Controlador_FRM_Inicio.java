/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import vista.FRM_Inicio;

/**
 *
 * @author Casa
 */
public class Controlador_FRM_Inicio implements ItemListener, ActionListener{
    
    FRM_Inicio frm_Inicio;
    public String opcionSeleccionada="0";
    public Controlador_FRM_Inicio(FRM_Inicio frm_Inicio) 
    {
        this.frm_Inicio=frm_Inicio;
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
       
    }
    
    public void itemStateChanged(ItemEvent e)
    {
       if(e.getItem()==frm_Inicio.panel_Inicio1.radio_Planos)
       {
           if(e.getStateChange()==1)
           {
               frm_Inicio.ventanaPrincipal.setVisible(true);
               frm_Inicio.opcion="Planos";
           }
       }
       if(e.getItem()==frm_Inicio.panel_Inicio1.radio_XML)
       {
           if(e.getStateChange()==1)
           {
               opcionSeleccionada="XML";
           }
       }
       if(e.getItem()==frm_Inicio.panel_Inicio1.radio_BD)
       {
           if(e.getStateChange()==1)
           {
               opcionSeleccionada="BD";
           }
       }
       
    }
   
    public String devolverOpcionSeleccionada()
    {
        return opcionSeleccionada;
    }
    
    

    
}
