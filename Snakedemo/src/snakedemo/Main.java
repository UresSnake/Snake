/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package snakedemo;

/**
 *
 * @author Lenovo
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Main extends JFrame implements KeyListener, ActionListener {
    
    Snakes snake;
    SettingsPanel settings;
    
    Color first;
    
        public Main(String a) {

        this.settings = new SettingsPanel(this);
        add(this.settings);

        setTitle("Settings");
        setSize(500, 500);
        this.addKeyListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

  
   

    public Main() {
        int winwidth=1000;
         int winheight=700;
        this.snake = new Snakes(this, winwidth, winheight);

        // timer for redrawing the screen
        Timer timer = new Timer(600, this);
        timer.start();

        // timer for drawing apples on the screen
        java.util.Timer drawApples = new java.util.Timer();
        Apple st1 = new Apple(this.snake);

        drawApples.schedule(st1, 0, 500);

        java.util.Timer drawGoldApples = new java.util.Timer();
        GoldApple st2 = new GoldApple(this.snake);
        drawGoldApples.schedule(st2, 0, 3000);
        
        java.util.Timer drawRottenApples = new java.util.Timer();
        RottenApple st3 = new RottenApple(this.snake);
        drawRottenApples.schedule(st3, 0, 1000);

        // window creation & drawing
        add(this.snake);

        setTitle("Snake Game");
        setSize(1000, 700);
        this.addKeyListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int c = e.getKeyCode();

        if (c == 39 && !this.snake.getDirectiona().equals("left")) {
            this.snake.setDirectiona("right"); // right arrow pressed
        } else if (c == 37 && !this.snake.getDirectiona().equals("right")) {
            this.snake.setDirectiona("left"); // left arrow pressed
        } else if (c == 38 && !this.snake.getDirectiona().equals("down")) {
            this.snake.setDirectiona("up"); // up arrow pressed
        } else if (c == 40 && !this.snake.getDirectiona().equals("up")) {
            this.snake.setDirectiona("down"); // down arrow pressed
        } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // redraw the screen
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main f = new Main("1");
    }
    
}
