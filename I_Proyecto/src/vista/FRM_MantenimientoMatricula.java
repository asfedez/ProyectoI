
package vista;

import controlador.Controlador_FRM_MantenimientoMatricula;
import javax.swing.table.DefaultTableModel;
import modelo.MetodosMatricula;

public class FRM_MantenimientoMatricula extends javax.swing.JFrame {

    Controlador_FRM_MantenimientoMatricula controlador_FRM_MantenimientoMatricula;
    DefaultTableModel modeloDeLaTabla;
    MetodosMatricula metodosMatricula;
    public FRM_MantenimientoMatricula(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes,FRM_MantenimientoCursos frm_MantenimientoCursos) 
    {
        initComponents();
        controlador_FRM_MantenimientoMatricula = new Controlador_FRM_MantenimientoMatricula(this,frm_MantenimientoEstudiantes,frm_MantenimientoCursos);
        modeloDeLaTabla= new DefaultTableModel();
        metodosMatricula=controlador_FRM_MantenimientoMatricula.metodosMatricula;
        colocarTitulosTabla();
        inicializarGUI();
        agregarEventos(controlador_FRM_MantenimientoMatricula);
    }
    
    public void agregarEventos(Controlador_FRM_MantenimientoMatricula controlador_FRM_MantenimientoMatricula)
    {
        btnConsultarCedula.addActionListener(controlador_FRM_MantenimientoMatricula);
        btnConsultarSigla.addActionListener(controlador_FRM_MantenimientoMatricula);
        btnFinalizar.addActionListener(controlador_FRM_MantenimientoMatricula);
        panel_Botones1.agregarEventosMatricula(controlador_FRM_MantenimientoMatricula);
    }
    
    
    
    public String[] devolverInformacionIngresada()
    {
        String arreglo[] = new String[2];
        arreglo[0]=txtCedula.getText();
        arreglo[1]=txtSigla.getText();
        return arreglo;
    }
    
    public void colocarNombreEstudiante(String nombre)
    {
        txtNombreEstudiante.setText(nombre);
    }
    public void colocarNombreCurso(String nombre)
    {
        txtNombreCurso.setText(nombre);
    }
    
    
    
    /***************Para agregar la tabla*********************/
    public void colocarTitulosTabla()
    {
        this.tbl_Tabla.setModel(modeloDeLaTabla);
        modeloDeLaTabla.addColumn("Código");
        modeloDeLaTabla.addColumn("Cédula");
        modeloDeLaTabla.addColumn("Nombre Est.");
        modeloDeLaTabla.addColumn("Sigla");
    }
    
    public int devolverFilaSeleccionada()
    {  
        return this.tbl_Tabla.getSelectedRow();
    }
    
     public String[] getMatriculaSeleccionada()
    {
        String informacion[] = new String[2];
        informacion[0] = ""+modeloDeLaTabla.getValueAt(devolverFilaSeleccionada(), 0);
        informacion[1]= ""+modeloDeLaTabla.getValueAt(devolverFilaSeleccionada(), 3);
        modeloDeLaTabla.removeRow(devolverFilaSeleccionada());
        return informacion;
    }
     
    public void agregarInformacionTabla(String arreglo[])
    {
            modeloDeLaTabla.addRow(arreglo);
            this.txtNombreEstudiante.setText(arreglo[2]);
            this.txtCedula.setText(arreglo[1]);
    }
    
     public void agregarInformacionTabla()
    {
        String arreglo[]=new String[4];
        arreglo[0]=this.txtCodigo.getText();
        arreglo[1]=this.txtCedula.getText();
        arreglo[2]=this.txtNombreEstudiante.getText();
        arreglo[3]=this.txtSigla.getText();
        modeloDeLaTabla.addRow(arreglo);
        
    }
   
     public void limpiarSigla()
     {
         txtNombreCurso.setText("");
         txtSigla.setText("");
     }
     
     
    public String devolverDato(int fila, int columna)
    {
        return ""+modeloDeLaTabla.getValueAt(fila, columna);
    }
    
     public String devolverCodigo()
    {
        return this.txtCodigo.getText();
    } 
     
    public int getCantidadFilas()
    {
        return modeloDeLaTabla.getRowCount();
    }
    
    public void colocarCodigo()
    {
        this.txtCodigo.setText(metodosMatricula.devolverCodigo());
       
    }
    /*****controles**/
     public void inicializarGUI()
     {
         txtCodigo.setEditable(true);
         txtCedula.setText("");
         txtCodigo.setText(""); 
         txtNombreEstudiante.setEnabled(false);
         txtNombreEstudiante.setText("");
         txtNombreCurso.setEnabled(false);
         txtNombreCurso.setText("");
      
     }
     
    public void habilitarAgregar()
    {
        panel_Botones1.habilitarAgregar();
        txtCodigo.setEnabled(true);
        txtCedula.setEnabled(false);
        txtSigla.setEnabled(false);
        txtNombreEstudiante.setEnabled(false);
        txtNombreCurso.setEnabled(false);
        
    }
    
    public void habilitarEdicion()
    {
        txtCodigo.setEnabled(true);
        txtCedula.setEnabled(false);
        txtSigla.setEnabled(false);
        txtNombreEstudiante.setEnabled(false);
        txtNombreCurso.setEnabled(false);
        panel_Botones1.habilitarEdicion();
    }
    

  
    
    
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombreEstudiante = new javax.swing.JTextField();
        txtSigla = new javax.swing.JTextField();
        txtNombreCurso = new javax.swing.JTextField();
        btnConsultarCedula = new javax.swing.JButton();
        btnConsultarSigla = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Tabla = new javax.swing.JTable();
        btnFinalizar = new javax.swing.JButton();
        panel_Botones1 = new vista.Panel_Botones();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jLabel1.setText("Cedula");

        jLabel2.setText("Nombre");

        jLabel3.setText("Sigla");

        jLabel4.setText("Nombre del curso");

        btnConsultarCedula.setText("Buscar");
        btnConsultarCedula.setActionCommand("Buscar Cedula");

        btnConsultarSigla.setText("Buscar");
        btnConsultarSigla.setActionCommand("Buscar Sigla");

        jLabel5.setText("Codigo");

        tbl_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_Tabla);

        btnFinalizar.setText("Finalizar matricula");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3))
                                            .addGap(56, 56, 56))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(60, 60, 60)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCedula)
                                    .addComponent(txtNombreEstudiante)
                                    .addComponent(txtNombreCurso)
                                    .addComponent(txtSigla)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnConsultarCedula)
                                    .addComponent(btnConsultarSigla))
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarCedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarSigla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
        controlador_FRM_MantenimientoMatricula.escribirInformacionEnElArchivo();
    }//GEN-LAST:event_formComponentHidden

     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarCedula;
    private javax.swing.JButton btnConsultarSigla;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private vista.Panel_Botones panel_Botones1;
    private javax.swing.JTable tbl_Tabla;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombreCurso;
    private javax.swing.JTextField txtNombreEstudiante;
    private javax.swing.JTextField txtSigla;
    // End of variables declaration//GEN-END:variables
}
