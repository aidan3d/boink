/**************************************************************
 *                B O I N K !                                 *
 *                                                            *
 * Author:        Aidan Hegarty                               *
 *                                                            *
 * Last modified: May 6, 2015                                 *
 *                                                            *
 * Description:   A platform game with an appetite for        *
 *                destruction! Help the green Boink-ball      *
 *                catch the blue Bink-ball by removing        *
 *                wooden platform planks.                     *
 *                                                            *
 **************************************************************/
package com.aidan3d.boink;
        
import Eureka.EurekaWindow;

/**
 * The BoinkWindow class is derived from a <b>EurekaWindow</b>
 * class, which is currently derived from the <b>JFrame</b>
 * class. The BoinkWindow object will hold a <b>BoinkPanel</b> object
 * (effectively a JPanel-derived object).
 * @author hardnett
 */
public class BoinkWindow extends EurekaWindow {
    private static final int DEFAULT_FPS = 1;  // the number of frames per second
    private static long period;                 // the time we want to "fill out" before updating
    

    /**
     * Creates new form BoinkWindow
     */
    public BoinkWindow() {
        initComponents();
        

    }

    public void windowActivated(java.awt.event.WindowEvent e) {
        ((BoinkPanel)panel).resumeGame();
    }
    
    public void windowDeactivated(java.awt.event.WindowEvent e) {
        ((BoinkPanel)panel).pauseGame();
    }
    
    public void windowDeiconified(java.awt.event.WindowEvent e) {
        ((BoinkPanel)panel).resumeGame();
    }
    
    public void windowIconified(java.awt.event.WindowEvent e) {
        ((BoinkPanel)panel).pauseGame();
    }
    
    public void windowClosing(java.awt.event.WindowEvent e) {
        ((BoinkPanel)panel).stopGame();
    }
    
    
    public void setLeftBox(String  text) {
        if (text.isEmpty())
            leftTextBox.setText("Default L Box");
        else
            leftTextBox.setText(text);
    }
    
    public void setRightBox(String text) {
        if (text.isEmpty())
            rightTextBox.setText("Default R Box");
        else
            rightTextBox.setText(text);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        rightTextBox = new javax.swing.JTextField();
        leftTextBox = new javax.swing.JTextField();
        panel = new com.aidan3d.boink.BoinkPanel(this, period*1000000L);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        org.jdesktop.layout.GroupLayout panelLayout = new org.jdesktop.layout.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 560, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(leftTextBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(rightTextBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 414, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(panel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(panel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(leftTextBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(rightTextBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        int fps = DEFAULT_FPS;
        if (args.length != 0)
            fps = Integer.parseInt(args[0]);
        
        period = (long)1000.0/fps;
        System.out.println("fps: " + fps + "; period: " + period + " ms");
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoinkWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoinkWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoinkWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoinkWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BoinkWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField leftTextBox;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField rightTextBox;
    // End of variables declaration//GEN-END:variables
}
