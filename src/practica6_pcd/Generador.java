/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6_pcd;

import java.util.concurrent.Semaphore;

/**
 *
 * @author usuario
 */
public class Generador extends java.awt.Frame {

    /**
     * Creates new form Generador
     */
    public Generador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        Generador Gen = new Generador();
        Gen.setSize(1024, 768);
        CanvasGenerador cv = new CanvasGenerador();
        Gen.add(cv);
        Gen.setVisible(true);
        Semaphore[] mesa = new Semaphore[4];
        
        for (int i = 0; i < 4; i++) {
            mesa[i] = new Semaphore(1);
        }
        
        Semaphore hoja = new Semaphore(0);
        
        RobotA[] robots = new RobotA[4];
        
        for (int i = 0; i < 4; i++) {
            robots[i] = new RobotA(mesa, hoja, i, cv);
        }
        RobotG GrapRob = new RobotG(mesa, hoja, cv);
        Thread Grapador = new Thread(GrapRob);
        
        for (int i = 0; i < 4; i++) {
            robots[i].start();
        }
        Grapador.start();
        
        for (int i = 0; i < 4; i++) {
            robots[i].join();
        }
        
        Grapador.interrupt();
        System.exit(0);
        
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}