package view;

import javax.swing.ImageIcon;

public class FrmSobre extends javax.swing.JFrame {

    /**
     * Creates new form FrmSobre
     */

    public FrmSobre() {
        initComponents();
        new funcoesNecessariasTodosFormularios(this).setCorBackgroundFormulario();
        new funcoesNecessariasTodosFormularios(this).setIconeFormulario();
        setImagemInstrucoes();
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSobre = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        lblImagemIntrucoes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(512, 444));
        setMinimumSize(new java.awt.Dimension(546, 510));
        setPreferredSize(new java.awt.Dimension(512, 444));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSobre.setFont(new java.awt.Font("Helvetica", 1, 48)); // NOI18N
        lblSobre.setForeground(new java.awt.Color(206, 197, 21));
        lblSobre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSobre.setText("Instruções");
        getContentPane().add(lblSobre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 546, -1));

        btnMenu.setBackground(new java.awt.Color(254, 254, 254));
        btnMenu.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(46, 46, 46));
        btnMenu.setText("Menu");
        btnMenu.setMaximumSize(new java.awt.Dimension(106, 38));
        btnMenu.setMinimumSize(new java.awt.Dimension(106, 38));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 110, 38));

        lblImagemIntrucoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblImagemIntrucoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 530, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        new FrmMenu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed
    
    // Carrega a imagem que contém as intruções do jogo
    private void setImagemInstrucoes() {
        ImageIcon imagem = new ImageIcon(FrmSobre.class.getClassLoader().getResource("imagens/instrucoes-dicas.png"));
        imagem.setImage(imagem.getImage().getScaledInstance(450, 280, 100));
        lblImagemIntrucoes.setIcon(imagem);
    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSobre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel lblImagemIntrucoes;
    private javax.swing.JLabel lblSobre;
    // End of variables declaration//GEN-END:variables
}
