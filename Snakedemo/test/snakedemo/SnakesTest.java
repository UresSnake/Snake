/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package snakedemo;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class SnakesTest {

    public SnakesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getBody1 method, of class Snakes.
     */
    @Test
    public void testGetBody1() {
        System.out.println("getBody1");
        Snakes instance = null;
        ArrayList<Rectangle> expResult = null;
        ArrayList<Rectangle> result = instance.getBody1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDirectiona method, of class Snakes.
     */
    @Test
    public void testSetDirectiona() {
        System.out.println("setDirectiona");
        String direction = "";
        Snakes instance = null;
        instance.setDirectiona(direction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDirectiona method, of class Snakes.
     */
    @Test
    public void testGetDirectiona() {
        System.out.println("getDirectiona");
        Snakes instance = null;
        String expResult = "";
        String result = instance.getDirectiona();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addParta method, of class Snakes.
     */
    @Test
    public void testAddParta() {
        System.out.println("addParta");
        Main a = new Main();
        Snakes instance = new Snakes(a, 500, 500);
        instance.addParta();
        // TODO review the generated test code and remove the default call to fail.
        assertThat(instance.getBody1().size(), is(4));
    }

    /**
     * Test of checkColissiona method, of class Snakes.
     */
    @Test
    public void testCheckColissiona() {
        System.out.println("checkColissiona");
        Main a = new Main();
        Snakes instance = new Snakes(a, 500, 500);
        java.util.Timer drawApples = new java.util.Timer();
        Apple apple = new Apple(instance);
        drawApples.schedule(apple, 0, 300);

        int applex = apple.getPosx();
        int appley = apple.getPosy();
        Rectangle first = instance.getBody1().get(0);
        int headx = first.getPosx();
        int heady = first.getPosy();

        assertThat(applex & appley, is(not(equalTo(headx & heady))));
    }

    /**
     * Test of checkColissiona method, of class Snakes.
     */
    @Test
    public void testCheckColissionaBorder() {
        System.out.println("checkColissionaBorder");
        Main a = new Main();
        Snakes instance = new Snakes(a, 500, 500);
        for (int i = 250; i < 500; i=i+25) {
            instance.setDirectiona("right");
            instance.moveSnakea();
        }

       
        int i = instance.getBody1().get(0).getPosx();
        assertThat(i, is(500));
    }

    /**
     * Test of moveSnakea method, of class Snakes.
     */
    @Test
    public void testMoveSnakea() {
        System.out.println("moveSnakea");
        Main a = new Main();
        Snakes instance = new Snakes(a, 500, 500);
        Rectangle first = instance.getBody1().get(0);
        Rectangle head = new Rectangle(first.getPosx(), first.getPosy());
        int x = first.getPosx();
        int y = first.getPosy();

        instance.setDirectiona("right");
        instance.moveSnakea();

        Rectangle first2 = instance.getBody1().get(0);
        assertThat(x, is(not(equalTo(first2.getPosx()))));

        instance.setDirectiona("down");
        instance.moveSnakea();

        // TODO review the generated test code and remove the default call to fail.
        first2 = instance.getBody1().get(0);
        assertThat(y, is(not(equalTo(first2.getPosx()))));

    }

    /**
     * Test of setApple method, of class Snakes.
     */
    @Test
    public void testSetApple() {
        System.out.println("setApple");
        Apple apple = null;
        Snakes instance = null;
        instance.setApple(apple);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApple method, of class Snakes.
     */
    @Test
    public void testGetApple() {
        System.out.println("getApple");
        Snakes instance = null;
        Apple expResult = null;
        Apple result = instance.getApple();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");

    }

    /**
     * Test of setGoldApple method, of class Snakes.
     */
    @Test
    public void testSetGoldApple() {
        System.out.println("setGoldApple");
        GoldApple apple = null;
        Snakes instance = null;
        instance.setGoldApple(apple);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGoldApple method, of class Snakes.
     */
    @Test
    public void testGetGoldApple() {
        System.out.println("getGoldApple");
        Snakes instance = null;
        GoldApple expResult = null;
        GoldApple result = instance.getGoldApple();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRottenApple method, of class Snakes.
     */
    @Test
    public void testSetRottenApple() {
        System.out.println("setRottenApple");
        RottenApple rottenapple = null;
        Snakes instance = null;
        instance.setRottenApple(rottenapple);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRottenApple method, of class Snakes.
     */
    @Test
    public void testGetRottenApple() {
        System.out.println("getRottenApple");
        Snakes instance = null;
        RottenApple expResult = null;
        RottenApple result = instance.getRottenApple();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class Snakes.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        Snakes instance = null;
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
