/**
 * A silly class with a few methods to show how JUnit works.  The
 * basic object is simply a counter that can be bumped up by various amounts.
 * 
 * @author dlevine
 * @version 20 January 2016
 *
 */
public class Something {

    private int counter;
    
    /**
     * Create an object starting at zero
     */
    public Something() {
        this(0);
    }
    
    /**
     * Create an object with a specified starting value
     * @param n the value at which to start
     */
    public Something(int n) {
        counter = n;
    }
    
    /**
     * return the value associated with this object
     * @return the value associated with this object
     */
    public int getCounter() {
        return counter;
    }
   
    /** 
     * Increase the value of the object by an amount 
     * @param addOn the amount of the increase
     * @throws IllegalArgumentException if <code>addOn</code> is negative
     */
    public void bump(int addOn) {
        if (addOn < 0) {
            throw new IllegalArgumentException("Can't bump by negative amount");
        }
        counter += addOn;
    }
    
    /**
     * Reset the value of this object to zero
     */
    public void reset() {
        counter = 0;
    }
    
}
