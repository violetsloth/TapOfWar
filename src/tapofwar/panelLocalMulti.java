/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tapofwar;

import com.sun.glass.events.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LoganLee
 */
public class panelLocalMulti extends javax.swing.JPanel{
    private int ctr;
    private int player1ctr=0;
    private int player2ctr=0;
    private int timeLimit = 10;
    private int timeReady = 5;
    private boolean isTimeUp = false;
    private int preTimer;
    /**
     * Creates new form panel2Player
     */
    public panelLocalMulti() {
        initComponents();
        //timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barMain = new javax.swing.JProgressBar();
        ctrlabel = new javax.swing.JLabel();
        ctrlabel2 = new javax.swing.JLabel();
        p1power = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        barMain.setValue(50);

        ctrlabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        ctrlabel.setText("Player 1");

        ctrlabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        ctrlabel2.setText("Player 2");

        p1power.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        p1power.setText("No power");

        timerLabel.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(timerLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(barMain, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p1power)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ctrlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(ctrlabel2)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(barMain, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ctrlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ctrlabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p1power, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        moveBar(evt);
    }//GEN-LAST:event_formKeyReleased
    
    public void moveBar(java.awt.event.KeyEvent evt){
        if(isTimeUp == false && preTimer >= 0){
            if(evt.getKeyCode()== KeyEvent.VK_M){
                player1ctr++;
                ctrlabel.setText(""+player1ctr);
                if(player1ctr==10){
                    p1power.setText("N-NANI??");
                }    

                barMain.setValue(barMain.getValue() - 1);
            }else if(evt.getKeyCode()== KeyEvent.VK_Z){
                player2ctr++;
                ctrlabel2.setText(""+player2ctr);

                barMain.setValue(barMain.getValue() + 1);
            }
        }
    }
    
    
    Thread timer = new Thread() {
        public void run() {
            
            for (ctr = timeLimit + timeReady; ctr >= 0; --ctr) {
                preTimer = timeLimit - ctr;
                try {
                    if(preTimer<=-1){
                        timerLabel.setText(Integer.toString(ctr-timeLimit));
                    } else if(preTimer==0){
                        timerLabel.setText("Start!");
                    } else {
                        timerLabel.setText(Integer.toString(ctr));
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TapOfWar_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(ctr==0){
                    isTimeUp = true;
                    pointCounter();
                }
            }
        }
    };
    
    private void pointCounter() {
        if (player1ctr > player2ctr) {
            timerLabel.setText("Player 1 Wins!");
        } else if(player1ctr < player2ctr){
            timerLabel.setText("Player 2 Wins!");
        }else{
            timerLabel.setText("Draw!");
        }
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barMain;
    private javax.swing.JLabel ctrlabel;
    private javax.swing.JLabel ctrlabel2;
    private javax.swing.JLabel p1power;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}