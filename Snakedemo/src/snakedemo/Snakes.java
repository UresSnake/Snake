/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakedemo;

/**
 *
 * @author Lenovo
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import static snakedemo.Rectangle.rec_height;
import static snakedemo.Rectangle.rec_width;

public class Snakes extends JPanel {
    
    private static final Color c = new Color(115, 162, 78);
    private static final int start1 = 250;
  
    private static final int speed = 25;

    private ArrayList<Rectangle> body1;
    

    private String direction1;
    private String direction2;

    private Apple apple;
    private GoldApple goldapple;
    private RottenApple rottenapple;

    private Main window;

    private Color first;
    private Color second;
    private int winwidth;
    private int winheight;
    private int score1;
    private int score2;
    
     public Snakes(snakedemo.Main window, int winwidth, int winheight) {
        this.winwidth = winwidth;
        this.winheight = winheight;
        this.window = window;
        this.first = Color.blue;
        this.score1=0;
        

        this.body1 = new ArrayList<>();

        Rectangle a = new Rectangle(start1, start1);

        body1.add(a);
        Rectangle lasta = this.body1.get(0);
        body1.add(new Rectangle(lasta.getPosx() - rec_width, lasta.getPosy()));
        Rectangle lasta_2 = this.body1.get(1);
        body1.add(new Rectangle(lasta_2.getPosx() - rec_width, lasta_2.getPosy()));
        this.direction1 = "right";
    }

    public ArrayList<Rectangle> getBody1() {
        return this.body1;
    }

    public void setDirectiona(String direction) {
        this.direction1 = direction;
    }

    public String getDirectiona() {
        return this.direction1;
    }

   

    public void addParta() {
        Rectangle lasta = this.body1.get(this.body1.size() - 1);
        switch (this.direction1) {
            case "right" ->
                this.body1.add(new Rectangle(lasta.getPosx() - rec_width, lasta.getPosy()));
            case "left" ->
                this.body1.add(new Rectangle(lasta.getPosx() + rec_width, lasta.getPosy()));
            case "up" ->
                this.body1.add(new Rectangle(lasta.getPosx(), lasta.getPosy() + rec_width));
            case "down" ->
                this.body1.add(new Rectangle(lasta.getPosx(), lasta.getPosy() - rec_width));
        }
    }

   
    public void checkColissiona() {
        Rectangle r3 = this.body1.get(0);

        for (int i = 1; i < this.body1.size(); i++) {
            Rectangle r2 = this.body1.get(i);

            if (r3.intersects(r2)) {
                System.out.println("You lose!");
                this.window.setVisible(false);

                JFrame parent = new JFrame("Game over!");
                JOptionPane.showMessageDialog(parent, "Your score: " + score1);

                this.window.dispatchEvent(new WindowEvent(this.window, WindowEvent.WINDOW_ACTIVATED));
                //System.exit(0);
            }
        }

        if (this.apple != null) {
            if (r3.intersects(new Rectangle(this.apple.getPosx(), this.apple.getPosy()))) {
                score1+=this.apple.getPoint();
                this.apple = null;
                this.addParta();
            }
        }

        if (this.goldapple != null) {
            if (r3.intersects(new Rectangle(this.goldapple.getPosx(), this.goldapple.getPosy()))) {
                score1+=this.goldapple.getPoint();
                this.goldapple = null;               
                this.addParta();
            }
        }
        
          if (this.rottenapple != null) {
            if (r3.intersects(new Rectangle(this.rottenapple.getPosx(), this.rottenapple.getPosy()))) {
                score1-=this.rottenapple.getPoint();
                this.rottenapple = null;
                this.addParta();
            }
        }

    }

   

    public void moveSnakea() {

        ArrayList<Rectangle> newLst = new ArrayList<>();

        Rectangle first = this.body1.get(0);
        if (first.getPosx() <= 0 || first.getPosx() >= winwidth || first.getPosy() <= 0 || first.getPosy() >= winheight) {
             this.window.setVisible(false);
            JFrame parent = new JFrame("Game over!");
            
            JOptionPane.showMessageDialog(parent, "Your score: " +score1);
            
            this.window.dispatchEvent(new WindowEvent(this.window, WindowEvent.WINDOW_ACTIVATED));
            //System.exit(0);
        }
        
        Rectangle head = new Rectangle(first.getPosx(), first.getPosy());

        switch (this.direction1) {
            case "right" ->
                head.setPosx(speed);
            case "left" ->
                head.setPosx(-speed);
            case "up" ->
                head.setPosy(-speed);
            case "down" ->
                head.setPosy(speed);
        }
        newLst.add(head);

        for (int i = 1; i < this.body1.size(); i++) {
            Rectangle previous = this.body1.get(i - 1);
            Rectangle newRec = new Rectangle(previous.getPosx(), previous.getPosy());
            newLst.add(newRec);
        }

        this.body1 = newLst;
        
            checkColissiona();
        
    }

   
    

    private void drawSnakea(Graphics g) {
        moveSnakea();

        // draw moved snake
        Graphics2D g2d = (Graphics2D) g;

        if (this.apple != null) {
            g2d.setPaint(Color.red);
            g2d.drawRect(this.apple.getPosx(), this.apple.getPosy(), rec_width, rec_height);
            g2d.fillRect(this.apple.getPosx(), this.apple.getPosy(), rec_width, rec_height);
        }
        if (this.goldapple != null) {
            g2d.setPaint(Color.orange);
            g2d.drawRect(this.goldapple.getPosx(), this.goldapple.getPosy(), rec_width, rec_height);
            g2d.fillRect(this.goldapple.getPosx(), this.goldapple.getPosy(), rec_width, rec_height);
        }
         if (this.rottenapple != null) {
            g2d.setPaint(Color.BLACK);
            g2d.drawRect(this.rottenapple.getPosx(), this.rottenapple.getPosy(), rec_width, rec_height);
            g2d.fillRect(this.rottenapple.getPosx(), this.rottenapple.getPosy(), rec_width, rec_height);
        }
        g2d.setPaint(first);
        for (Rectangle rec : this.body1) {
            g2d.drawRect(rec.getPosx(), rec.getPosy(), rec_width, rec_height);
            g2d.fillRect(rec.getPosx(), rec.getPosy(), rec_width, rec_height);
        }
    }

  

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public Apple getApple() {
        return this.apple;
    }

    public void setGoldApple(GoldApple apple) {
        this.goldapple = apple;
    }

    public GoldApple getGoldApple() {
        return this.goldapple;
    }

     public void setRottenApple(RottenApple rottenapple) {
        this.rottenapple = rottenapple;
    }

    public RottenApple getRottenApple() {
        return this.rottenapple;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(c);
        drawSnakea(g);
       
    }
    
}
