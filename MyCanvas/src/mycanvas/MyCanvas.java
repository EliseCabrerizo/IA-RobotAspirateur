package mycanvas;

import environnement.Environnement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class MyCanvas extends JComponent {
  
  public void paintComponent(Graphics g, Environnement environnement) {
    super.paintComponent(g);
    // draw entire component white
    //g.setColor(Color.white);
    //g.fillRect(0, 0, getWidth(), getHeight());
    
    
    boolean poussiere = false;  
    boolean bijou = false;
    String path;
    
    //Parcours de toutes les cases
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            path = "C:\\Vincent\\Cours uqac\\Intelligence artificielle\\TP1\\MyCanvas\\src\\ressource\\";
            poussiere = environnement.getCase(i, j).getPoussiere();
            bijou = environnement.getCase(i, j).getBijoux();

            //bijou + poussiere
             if (bijou && poussiere)  
                 path = path + "diamant+poussiere.jpg";
             //bijou
             else if (bijou && !poussiere)                  
                 path = path + "diamant.jpg";
             //poussiere
             else if (!bijou && poussiere)                 
                 path = path + "poussiere.jpg";
             //vide
             else if (!bijou && !poussiere)                 
                 path = path + "case_vide.png";

            BufferedImage img = null;
            //Lecture du fichier image
            try {
                img = ImageIO.read(new File(path));
            } catch (IOException ex) {
                Logger.getLogger(MyCanvas.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Ecriture de l'image sur le canvas
            g.drawImage(img, 50*i, 50*j, null);
        }
    }
}
/*  
  public void drawOneImage(Graphics g, String s, int x, int y){
    BufferedImage img = null;
    try {
        img = ImageIO.read(new File(s));
    } catch (IOException ex) {
        Logger.getLogger(MyCanvas.class.getName()).log(Level.SEVERE, null, ex);
    }
    g.drawImage(img, x, y, null);
  }
  */
  public Dimension getPreferredSize() {
    return new Dimension(500, 500);
  }

  public Dimension getMinimumSize() {
    return getPreferredSize();
  }


  public static void main(String args[]) {
      //initialisation du frame et du canvas
    JFrame mainFrame = new JFrame("Graphics demo");
    MyCanvas c = new MyCanvas();
    mainFrame.getContentPane().add(c);
    mainFrame.pack();
    mainFrame.setVisible(true);
    
    Environnement environnement = new Environnement(10);
    while(true){
        c.paintComponent(c.getGraphics(), environnement);
        environnement.Generation();
        /*int pouss = 0;
        int bij = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (environnement.getCase(i, j).getBijoux()) bij++;
                if (environnement.getCase(i, j).getPoussiere()) pouss++;
            }
        }
        System.out.println("poussière : " + pouss);
        System.out.println("bijoux : " + bij);*/
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyCanvas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
    try {
        Thread.sleep(3000);
    } catch (InterruptedException ex) {
        Logger.getLogger(MyCanvas.class.getName()).log(Level.SEVERE, null, ex);
    }
    c.paintComponent(c.getGraphics(), "C:\\Vincent\\Cours uqac\\Intelligence artificielle\\TP1\\MyCanvas\\src\\ressource\\diamant.jpg");
    try {
        Thread.sleep(3000);
    } catch (InterruptedException ex) {
        Logger.getLogger(MyCanvas.class.getName()).log(Level.SEVERE, null, ex);
    }
    c.paintComponent(c.getGraphics(), "C:\\Vincent\\Cours uqac\\Intelligence artificielle\\TP1\\MyCanvas\\src\\ressource\\poussiere.jpg");
  */}
}
           
         