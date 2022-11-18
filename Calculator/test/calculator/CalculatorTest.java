/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package calculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author szako
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test
   public void testOsszead() {
      assertEquals("Hibás összeadás",  5, Calculator.add(3, 2));
      assertEquals("Hibás összeadás", -7, Calculator.add(-2, -5));
      assertEquals("Hibás összeadás",  11, Calculator.add(11, 0));
   }
 
 
   @Test
   public void testKivon() {
      assertEquals("Hibas kivonas",  2, Calculator.sub(3, 1));
      assertEquals("Hibas kivonas", -1, Calculator.sub(-2, -1));
      assertEquals("Hibas kivonas",  0, Calculator.sub(2, 2));
   }
 
   
   @Test
   public void testSzoroz() {
      assertEquals("Hibas szorzas",  3, Calculator.mul(3, 1));
      assertEquals("Hibas szorzas", 2, Calculator.mul(-2, -1));
      assertEquals("Hibas szorzas",  0, Calculator.mul(0, 2));
    
   }
    @Test
   public void testOszt() {
      assertEquals("Hibas osztas",  3, Calculator.divInt(3, 1));
      assertEquals("Hibas osztas", 4, Calculator.divInt(8, 2));   
      assertEquals("Hibas osztas", 3, Calculator.divInt(-6, -2));   
}
}
