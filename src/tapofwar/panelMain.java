/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tapofwar;

/**
 *
 * @author LoganLee
 */
public class panelMain extends javax.swing.JPanel {

    private final panelSinglePlayer panelSingle;
    private final panel2Player panel2Player;
    private final panelSetting panelSetting;
    private panelMain panelMain;
    
    /**
     * Creates new form panelMain
     */
    public panelMain(panelSinglePlayer panelSingle, panel2Player panel2Player, panelSetting panelSetting) {
        initComponents();
        this.panelSingle = panelSingle;
        this.panel2Player = panel2Player;
        this.panelSetting = panelSetting;
    }

    public void setPanelMain(panelMain panelMain) {
        this.panelMain = panelMain;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMain = new javax.swing.JLabel();
        btnSinglePlayer = new javax.swing.JButton();
        btn2Player = new javax.swing.JButton();
        btnSetting = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setBackground(new java.awt.Color(63, 32, 69));

        lblMain.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 36)); // NOI18N
        lblMain.setForeground(new java.awt.Color(254, 220, 159));
        lblMain.setText("Tap Of War");

        btnSinglePlayer.setBackground(new java.awt.Color(255, 0, 0));
        btnSinglePlayer.setText("Single Player");
        btnSinglePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSinglePlayerActionPerformed(evt);
            }
        });

        btn2Player.setBackground(new java.awt.Color(254, 220, 159));
        btn2Player.setText("2 Player");
        btn2Player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2PlayerActionPerformed(evt);
            }
        });

        btnSetting.setBackground(new java.awt.Color(254, 220, 159));
        btnSetting.setText("Settings");
        btnSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(254, 220, 159));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSinglePlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn2Player, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(lblMain)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(lblMain)
                .addGap(134, 134, 134)
                .addComponent(btnSinglePlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn2Player)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSetting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addContainerGap(156, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSinglePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSinglePlayerActionPerformed
        panelMain.setVisible(false);
        panelSingle.setVisible(true);
    }//GEN-LAST:event_btnSinglePlayerActionPerformed

    private void btn2PlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2PlayerActionPerformed
        panelMain.setVisible(false);
        panel2Player.setVisible(true);
        panel2Player.requestFocusInWindow();
    }//GEN-LAST:event_btn2PlayerActionPerformed

    private void btnSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingActionPerformed
        panelMain.setVisible(false);
        panelSetting.setVisible(true);
    }//GEN-LAST:event_btnSettingActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn2Player;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSetting;
    private javax.swing.JButton btnSinglePlayer;
    private javax.swing.JLabel lblMain;
    // End of variables declaration//GEN-END:variables
}
