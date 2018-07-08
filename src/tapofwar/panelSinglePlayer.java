/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tapofwar;

import com.sun.glass.events.KeyEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LoganLee
 */
public class panelSinglePlayer extends javax.swing.JPanel {
    private int player1ctr;
    private int compCtr;
    private int ctr;
    private int timeLimit;
    private int timeReady;
    private int preTimer;
    private Random random;
    private boolean isTimeUp;
    
    /**
     * Creates new form panelSinglePlayer
     */
    public panelSinglePlayer() {
        initComponents();
        
        random = new Random();
        
        timeReady = 5;
        timeLimit = 10;
        
        timer.start();
    }
    
    public void displayWinner(){
        if(barMain.getValue()>=100){
            timerLabel.setText("You Lose");
        } else if (barMain.getValue()<=0){
            timerLabel.setText("You Win");
        } else if (player1ctr>compCtr){
            timerLabel.setText("You Win");
        } else if (player1ctr<compCtr){
            timerLabel.setText("You Lose");
        }
        
    }
    
    Thread timer = new Thread() {
        public void run() {
            
            for (ctr = timeLimit + timeReady; ctr >= 0 && isFinished()!=true; --ctr) {
                preTimer = timeLimit - ctr;
                try {
                    
                    if(preTimer<=-1){
                        timerLabel.setText(Integer.toString(ctr-timeLimit));
                    } else if(preTimer==0){
                        timerLabel.setText("Start!");
                        comp.start();
                    } else {
                        timerLabel.setText(Integer.toString(ctr));
                    }
                    
                    Thread.sleep(1000);
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(TapOfWar_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                displayWinner();
                if(ctr==0){
                    isTimeUp = true;
                    //pointCounter();
                }
            } 
        }
    };
    
    Thread comp = new Thread(){
        
        public void run(){
            
            while(ctr>=0){
                try {
                    compCtr = random.nextInt(2);
                    barMain.setValue(barMain.getValue()+compCtr);
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(panelSinglePlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    };
    
    public boolean isFinished(){
        return (barMain.getValue()>=100 || barMain.getValue()<=0);
        
    }
    
    public void moveBar(java.awt.event.KeyEvent evt){
        if(isTimeUp == false && preTimer >= 0){
            if(evt.getKeyCode()== KeyEvent.VK_M){
                player1ctr++;
                ctrlabel.setText(""+player1ctr);
                /*if(player1ctr==10){
                    p1power.setText("N-NANI??");
                }    
                */
                barMain.setValue(barMain.getValue() - 1);
            }
        }
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
        timerLabel = new javax.swing.JLabel();
        ctrlabel = new javax.swing.JLabel();

        barMain.setBackground(new java.awt.Color(250, 250, 250));
        barMain.setValue(50);

        timerLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        ctrlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(barMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(ctrlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(barMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(ctrlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(371, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barMain;
    private javax.swing.JLabel ctrlabel;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
