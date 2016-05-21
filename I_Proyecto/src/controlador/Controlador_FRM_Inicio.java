
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import vista.FRM_Inicio;
import vista.FRM_MenuPrincipal;

public class Controlador_FRM_Inicio implements ItemListener, ActionListener{
    
    FRM_Inicio frm_Inicio;
    FRM_MenuPrincipal frm_MenuPrincipal;
    Controlador_FRM_MenuPrincipal controlador_FRM_MenuPrincipal;
    public Controlador_FRM_Inicio(FRM_Inicio frm_Inicio) 
    {
        frm_MenuPrincipal=new FRM_MenuPrincipal();
        this.frm_Inicio=frm_Inicio;
        controlador_FRM_MenuPrincipal= new Controlador_FRM_MenuPrincipal(frm_MenuPrincipal);
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
               frm_Inicio.setOpcion("Planos");
               frm_MenuPrincipal.setVisible(true);
               frm_MenuPrincipal.controlador_FRM_MenuPrincipal.setOpcion(frm_Inicio.getOpcion());
           }
           
       }
       if(e.getItem()==frm_Inicio.panel_Inicio1.radio_XML)
       {
           if(e.getStateChange()==1)
           {
               frm_Inicio.setOpcion("XML");
              frm_MenuPrincipal.setVisible(true);
              frm_MenuPrincipal.controlador_FRM_MenuPrincipal.setOpcion(frm_Inicio.getOpcion());
           }
       }
       if(e.getItem()==frm_Inicio.panel_Inicio1.radio_BD)
       {
           if(e.getStateChange()==1)
           {
               frm_Inicio.setOpcion("BD");
               frm_MenuPrincipal.setVisible(true);
               frm_MenuPrincipal.controlador_FRM_MenuPrincipal.setOpcion(frm_Inicio.getOpcion());
           }
       }
       
    }
    
    
   

}
