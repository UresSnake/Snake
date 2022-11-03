/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakedemo;

import java.util.Random;
import java.util.TimerTask;

/**
 *
 * @author Lenovo
 */
public class GoldApple extends TimerTask{
    private int posx;
    private int posy;
    private Snakes snake;
    private int point=300;

 public int getPoint() {
        return point;
    }
 
    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public GoldApple(Snakes snake) {
        this.snake = snake;
    }

    public GoldApple() {
        this.posx = 25 * new Random().nextInt(20);
        this.posy = 25 * new Random().nextInt(20);
    }
@Override
    public void run() {
        if (this.snake.getGoldApple() == null) {
            this.snake.setGoldApple(new GoldApple());
        }
    }
    
}

