/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_MantenimientoCursos;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class FRM_MantenimientoCursos extends javax.swing.JFrame {

   
    public Controlador_FRM_MantenimientoCursos controlador;
    public FRM_MantenimientoCursos() {
        initComponents();
        inicializarGUI();
        controlador = new Controlador_FRM_MantenimientoCursos(this);
        panel_Botones1.agregarEventosCursos(controlador);

    }
    
    public void establecerOpcionAlControlador(String opcion)
    {
       controlador.setOpcion(opcion);
    }

     public  String[] devolverInformacionIngresada()
    {
        return this.panel_InformacionCursos1.devolverInformacionIngresada();
    }
     public void mostrarInformacion(String arreglo[])
    {
        this.panel_InformacionCursos1.mostrarInformacion(arreglo);
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void inicializarGUI()
    {
        this.panel_InformacionCursos1.inicializarGUI();
        this.panel_Botones1.inicializarGUI();
        this.panel_InformacionCursos1.llenarJCB();
    }
    
    public void habilitarAgregar()
    {
        this.panel_InformacionCursos1.habilitarEdicion();
        this.panel_Botones1.habilitarAgregar();
    }
    
    public void habilitarEdicion()
    {
        this.panel_InformacionCursos1.habilitarEdicion();
        this.panel_Botones1.habilitarEdicion();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_InformacionCursos1 = new vista.Panel_InformacionCursos();
        panel_Botones1 = new vista.Panel_Botones();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(panel_InformacionCursos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_InformacionCursos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
        if(controlador.getOpcion().equals("Planos"))
            controlador.escribirInformacionEnElArchivo();
    }//GEN-LAST:event_formComponentHidden


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.Panel_Botones panel_Botones1;
    private vista.Panel_InformacionCursos panel_InformacionCursos1;
    // End of variables declaration//GEN-END:variables
}
