/**
 * JUnit test class to demonstrate simple use of JUnit tests
 * Note the tests here are incomplete in a few ways
 * 
 * @author dlevine
 * @version 20 January 2016
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class SomethingTest1 {

    @Test
    public void testCreate() {
        Something s = new Something();
        assertEquals("Bad creation", 0, s.getCounter());
    }

    @Test
    public void testCreateWithParameter() {
        Something s = new Something(23);
        assertEquals("Bad parameterized creation", 23, s.getCounter());
    }

    @Test
    public void testBump() {
        Something s = new Something(6);
        assertEquals("Bad creation in testBump", 6, s.getCounter());
        s.bump(21);
        assertEquals("Bad first bump", 27, s.getCounter());
        s.bump(4);
        assertEquals("Bad second bump", 31, s.getCounter());
     }
    
    @Test
    public void testMultiple() {
        Something s = new Something(144);
        assertEquals("Bad creation of first object", 144, s.getCounter());
        Something t = new Something(98);
        assertEquals("Bad creation of second object", 98, t.getCounter());
       
        s.bump(2);
        assertEquals("Bad bump of one item", 146, s.getCounter());
        assertEquals("Bump caused interference in second item", 98, t.getCounter());
     }  
 
}
