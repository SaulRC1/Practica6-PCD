/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6_pcd;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class RobotA extends Thread {

    private Semaphore[] mesa;
    private Semaphore hoja;
    private int id;
    private CanvasGenerador cv;

    public RobotA(Semaphore[] m, Semaphore h, int id, CanvasGenerador cv) {
        this.mesa = m;
        this.hoja = h;
        this.id = id;
        this.cv = cv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                cogerHoja();
                mesa[id].acquire();
                
                System.out.println("Robot [" + id + "] Poner Hoja");
                cv.poneHoja(id);
                hoja.release();
            } catch (Exception ex) {
                Logger.getLogger(RobotA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void cogerHoja() throws InterruptedException {
        Random aleatorio = new Random();
        aleatorio.setSeed(this.getId());
        Thread.sleep((aleatorio.nextInt(3) + 1) * 1000);
        System.out.println("Robot [" + id + "] Coge Hoja");
    }

}
