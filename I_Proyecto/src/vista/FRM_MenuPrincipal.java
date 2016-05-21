
package vista;

import controlador.Controlador_FRM_MenuPrincipal;


public class FRM_MenuPrincipal extends javax.swing.JFrame {

    Controlador_FRM_MenuPrincipal controlador_FRM_MenuPrincipal;
    
    public FRM_MenuPrincipal() {
        initComponents();
        controlador_FRM_MenuPrincipal= new Controlador_FRM_MenuPrincipal(this);
        agregarEventos(controlador_FRM_MenuPrincipal);
    }

    
    public void agregarEventos(Controlador_FRM_MenuPrincipal controlador)
    {
        this.menuItemEstudiantes.addActionListener(controlador);
        this.menuItemCursos.addActionListener(controlador);
        this.menuItemMatricula.addActionListener(controlador);
        this.menuItemUsuarios.addActionListener(controlador);
        this.menuItemSalir.addActionListener(controlador);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemEstudiantes = new javax.swing.JMenuItem();
        menuItemCursos = new javax.swing.JMenuItem();
        menuItemMatricula = new javax.swing.JMenuItem();
        menuItemUsuarios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Archivo");

        menuItemSalir.setText("Salir");
        jMenu1.add(menuItemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Mantenimiento");

        menuItemEstudiantes.setText("Estudiantes");
        jMenu2.add(menuItemEstudiantes);

        menuItemCursos.setText("Cursos");
        jMenu2.add(menuItemCursos);

        menuItemMatricula.setText("Matricula");
        jMenu2.add(menuItemMatricula);

        menuItemUsuarios.setText("Usuarios");
        jMenu2.add(menuItemUsuarios);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuItemCursos;
    private javax.swing.JMenuItem menuItemEstudiantes;
    private javax.swing.JMenuItem menuItemMatricula;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenuItem menuItemUsuarios;
    // End of variables declaration//GEN-END:variables
}
