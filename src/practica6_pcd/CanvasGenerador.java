/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6_pcd;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author usuario
 */
public class CanvasGenerador extends Canvas{
    private boolean[] robots = new boolean[4];
    private boolean grapador;
    private boolean grapador_cinta;
    public CanvasGenerador(){
        super();
        
        for (int i = 0; i < 4; i++) {
            robots[i] = false;
        }
        
        grapador = false;
        grapador_cinta = false;
        
        setBackground(Color.DARK_GRAY);
        this.setSize(1024,768);
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        Image offscreen = createImage(this.getWidth(), this.getHeight());
        Graphics bg = offscreen.getGraphics();
        bg.setColor(Color.white);
        bg.fillRect(15, 30, 100, 600);
        bg.fillRect(400, 30, 200, 600);
        bg.fillRect(800, 30, 100, 600);
        int separacion = 0;
        Font f1 = new Font("Courier", Font.BOLD, 30);
        bg.setFont(f1);
        
        bg.drawString("Robot[0]", 160, 100);
        bg.drawString("Robot[1]", 160, 250);
        bg.drawString("Robot[2]", 160, 400);
        bg.drawString("Robot[3]", 160, 550);
        Font f2 = new Font("Courier", Font.BOLD, 20);
        bg.setFont(f2);
        bg.drawString("Robot[Grapador]", 620, 300);
        
        bg.setColor(Color.black);
        
        bg.drawRect(35, 50, 50, 50);
        bg.drawRect(50, 60, 50, 50);
        
        bg.drawRect(35, 200, 50, 50);
        bg.drawRect(50, 210, 50, 50);
        
        bg.drawRect(35, 350, 50, 50);
        bg.drawRect(50, 360, 50, 50);
        
        bg.drawRect(35, 500, 50, 50);
        bg.drawRect(50, 510, 50, 50);
        
        for (int i = 0; i < 4; i++) {
            if(robots[i] != false){
                bg.drawRect(420, 50 + separacion, 50, 50);
                separacion += 150;
            }
        }
        
        if(grapador != false){
            bg.drawRect(520, 300, 50, 50);
            bg.drawRect(535, 310, 50, 50);
        }
        
        if(grapador_cinta != false){
            bg.drawRect(820, 300, 50, 50);
            bg.drawRect(835, 310, 50, 50);
        }
        
        g.drawImage(offscreen, 0, 0, null);
    }
    
    @Override
    public void update(Graphics g){
        paint(g);
    }
    
    public void poneHoja(int id){
        robots[id] = true;
        repaint();
    }
    
    public void grapaHoja(){
        this.grapador = true;
        for (int i = 0; i < 4; i++) {
            robots[i] = false;
        }
        repaint();
    }
    
    public void poneCinta(){
        this.grapador_cinta = true;
        this.grapador = false;
        repaint();
    }
    
    public void liberaCinta(){
        this.grapador_cinta = false;
        repaint();
    }
    
    
    
}
