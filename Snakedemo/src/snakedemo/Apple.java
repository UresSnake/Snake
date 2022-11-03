/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakedemo;

/**
 *
 * @author Lenovo
 */
import java.util.Random;
import java.util.TimerTask;

public class Apple extends TimerTask {

    private int posx;
    private int posy;
    private Snakes snake;
    private int point = 100;

    public int getPoint() {
        return point;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public Apple(Snakes snake) {
        this.snake = snake;
    }

    public Apple() {
        this.posx = 25 * new Random().nextInt(20);
        this.posy = 25 * new Random().nextInt(20);
    }

    @Override
    public void run() {
        if (this.snake.getApple() == null) {
            this.snake.setApple(new Apple());
        }
    }
}
