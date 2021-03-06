/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_Inicio;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;


/**
 *
 * @author Casa
 */
public class Panel_Inicio extends javax.swing.JPanel {


    public Panel_Inicio() {
        initComponents();     
       agregarAGrupoBotones();
       
    }
    
    //Evento para agregar los radio botones al grupo de botones
    public void agregarAGrupoBotones()
    {
        this.grupoDeBotones.add(radio_Planos);
        this.grupoDeBotones.add(radio_XML);
        this.grupoDeBotones.add(radio_BD);
    }  
    //Evento para agregar eventos a los radio botones
    public void agregarEventos(Controlador_FRM_Inicio controlador_FRM_Inicio)
    {
        this.radio_Planos.addItemListener(controlador_FRM_Inicio);
        this.radio_XML.addItemListener(controlador_FRM_Inicio);
        this.radio_BD.addItemListener(controlador_FRM_Inicio);
        this.radio_Planos.addActionListener(controlador_FRM_Inicio);
        this.radio_XML.addActionListener(controlador_FRM_Inicio);
        this.radio_BD.addActionListener(controlador_FRM_Inicio);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoDeBotones = new javax.swing.ButtonGroup();
        radio_Planos = new javax.swing.JRadioButton();
        radio_XML = new javax.swing.JRadioButton();
        radio_BD = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        radio_Planos.setText("Archivos Planos");
        radio_Planos.setActionCommand("c");

        radio_XML.setText("Archivos XML");

        radio_BD.setText("Base de datos");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(this);
        jLabel1.setText("Seleccione una opción");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(radio_XML, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radio_BD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(radio_Planos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(radio_Planos)
                .addGap(18, 18, 18)
                .addComponent(radio_XML)
                .addGap(18, 18, 18)
                .addComponent(radio_BD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupoDeBotones;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JRadioButton radio_BD;
    public javax.swing.JRadioButton radio_Planos;
    public javax.swing.JRadioButton radio_XML;
    // End of variables declaration//GEN-END:variables
}
