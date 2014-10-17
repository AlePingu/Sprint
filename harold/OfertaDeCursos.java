

package ventanas;

import javax.swing.table.DefaultTableModel;

public class OfertaDeCursos extends javax.swing.JFrame {

    DefaultTableModel md;
    String posicion [][]={};
    String cabeza []={"Hora","Nombre","Fecha","Lugar"};
    
    
    public OfertaDeCursos() {
       
        initComponents();
        md= new DefaultTableModel(posicion,cabeza);
        jTcursos.setModel(md);
           llenarTabla();
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        botonAceptar = new javax.swing.JButton();
        jLTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTcursos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VistaCursos");
        setPreferredSize(new java.awt.Dimension(1024, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        botonAceptar.setForeground(new java.awt.Color(51, 51, 51));
        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAceptar);
        botonAceptar.setBounds(200, 280, 71, 23);

        jLTitulo.setBackground(new java.awt.Color(255, 204, 51));
        jLTitulo.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLTitulo.setText("CURSOS DISPONIBLES ");
        getContentPane().add(jLTitulo);
        jLTitulo.setBounds(150, 10, 181, 21);

        jTcursos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTcursos.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTcursosComponentAdded(evt);
            }
        });
        jScrollPane2.setViewportView(jTcursos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 40, 419, 227);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/FondoFormulario.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        dispose();
            
        
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
       setSize(500,400);
       
    }//GEN-LAST:event_formWindowOpened
    private void llenarTabla(){
        //while("estado disponible de curso == true"){
        Object hora= "consulta sql";
        Object nombre="consulta sql";
        Object fecha="consulta sql";
        Object lugar="consulta sql";
        Object llenando []={hora,nombre,fecha,lugar};
        md.addRow(llenando);
        llenarTabla();
        //}   
    }
    private void jTcursosComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTcursosComponentAdded
         
        
        
    }//GEN-LAST:event_jTcursosComponentAdded

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OfertaDeCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OfertaDeCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OfertaDeCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OfertaDeCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OfertaDeCursos().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTcursos;
    // End of variables declaration//GEN-END:variables
}
