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
public class RobotG implements Runnable {

    private Semaphore[] mesa;
    private Semaphore hoja;
    private CanvasGenerador cv;

    public RobotG(Semaphore[] mesa, Semaphore hoja, CanvasGenerador cv) {
        this.mesa = mesa;
        this.hoja = hoja;
        this.cv = cv;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (int i = 0; i < 4; i++) {
                    hoja.acquire();
                }

                System.out.println("ROBOT GRAPA HOJAS");
                /*Random aleatorio = new Random();
                aleatorio.setSeed(Thread.currentThread().getId());
                Thread.sleep((aleatorio.nextInt(3) + 1) * 1000);*/
                cv.grapaHoja();

                for (int i = 0; i < 4; i++) {
                    mesa[i].release();
                }

                ponerCinta();
            }

        } catch (InterruptedException ex) {
            System.out.println("Se ha acabado Grapador: " + ex.getMessage());
        }

    }

    public void ponerCinta() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Grapador Pone Hojas en la Cinta");
        cv.poneCinta();
        Thread.sleep(1000);
        cv.liberaCinta();

    }

}
