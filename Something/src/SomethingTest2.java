/**
 * Second JUnit test class to demonstrate more JUnit tests
 * This class picks up the reset method and demonstrates "inverted" testing
 * 
 * @author dlevine
 * @version 20 January 2016
 * 
 */


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SomethingTest2 {

    private Something s;
    private Something t;
    @Before
    public void setUp() throws Exception {
        s = new Something(45);
        t = new Something(28);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing Down");
    }

    @Test
    public void testReset() {
        assertEquals("setUp didn't work", 45, s.getCounter());
        assertEquals("setUp didn't work on second item", 28, t.getCounter());
        s.reset();
        assertEquals("reset didn't work", 0, s.getCounter());       
    }
    
    @Test
    public void testNegativeBump() {
        try {
            t.bump(-3);
            fail();
        } catch (IllegalArgumentException iae) {
        }
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeBump2()
    {
    	t.bump(-3);
    	fail();
    }
    

}
