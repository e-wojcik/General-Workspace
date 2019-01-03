import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test case for the isPrime method of IsPrime
 * 
 * @author Eric Wojcik
 * @version 05 February 2017
 *
 */
public class IsPrimeTest {

	@Test
	public void testBasicPrime() {
		assertTrue(IsPrime.isPrime(3));
	}

	@Test
	public void testNotPrime() {
		assertFalse(IsPrime.isPrime(6));
	}

	@Test
	public void testNegativeInt() {
		assertFalse(IsPrime.isPrime(-3));
	}

	@Test
	public void testZero() {
		assertFalse(IsPrime.isPrime(0));
	}

	@Test
	public void testLargePrime() {
		assertTrue(IsPrime.isPrime(524287));
	}

	@Test
	public void testEvenNumOverTwo() {
		assertFalse(IsPrime.isPrime(10));
	}

}
