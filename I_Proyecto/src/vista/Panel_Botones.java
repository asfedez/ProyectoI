/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_MantenimientoCursos;
import controlador.Controlador_FRM_MantenimientoEstudiantes;

/**
 *
 * @author Casa
 */
public class Panel_Botones extends javax.swing.JPanel {

    /**
     * Creates new form Panel_Botones
     */
    public Panel_Botones() {
        initComponents();
        inicializarGUI();
    }
    
    public void inicializarGUI()
    {
       btnConsultar.setEnabled(true);
       btnAgregar.setEnabled(false);
       btnModificar.setEnabled(false);
       btnEliminar.setEnabled(false);
    }
    
    public void habilitarAgregar()
    {
        btnConsultar.setEnabled(false);
        btnAgregar.setEnabled(true);
    }
    
    public void habilitarEdicion()
    {
       btnConsultar.setEnabled(false);
       btnAgregar.setEnabled(false);
       btnModificar.setEnabled(true);
       btnEliminar.setEnabled(true);
    }

    public void agregarEventos(Controlador_FRM_MantenimientoEstudiantes controlador_FRM_MantenimientoEstudiantes)
    {
        btnConsultar.addActionListener(controlador_FRM_MantenimientoEstudiantes);
        btnAgregar.addActionListener(controlador_FRM_MantenimientoEstudiantes);
        btnModificar.addActionListener(controlador_FRM_MantenimientoEstudiantes);
        btnEliminar.addActionListener(controlador_FRM_MantenimientoEstudiantes);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConsultar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/consultar.png"))); // NOI18N
        btnConsultar.setText("Consultar");

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnAgregar.setText("Agregar");

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnConsultar)
                .addComponent(btnAgregar)
                .addComponent(btnModificar)
                .addComponent(btnEliminar))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    // End of variables declaration//GEN-END:variables
}
