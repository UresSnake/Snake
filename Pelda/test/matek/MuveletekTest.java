package matek;

import org.junit.Test;
import static org.junit.Assert.*;


public class MuveletekTest {

    @Test
    public void testOsszeadas()
    {
        double a=6.0;
        double b=4.0;
        
        double expected=10.0;
        double result=Muveletek.osszeadas(a, b);
        
        assertEquals(expected, result, 0.001);
    }
    
    @Test
    public void testKivonas()
    {
        double a=6.0;
        double b=4.0;
        
        double expected=2.0;
        double result=Muveletek.kivonas(a, b);
        
        assertEquals(expected, result, 0.001);
    }
    
    @Test
    public void testSzorzas()
    {
        double a=6.0;
        double b=4.0;
        
        double expected=24.0;
        double result=Muveletek.szorzas(a, b);
        
        assertEquals(expected, result, 0.001);
    }
    
}
