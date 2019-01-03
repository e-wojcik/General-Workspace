import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test case for the TipUtilities class
 * 
 * @author Eric Wojcik
 * @version 22 January 2017
 */
public class TipUtilitiesTest {

	@Test
	public void testZero() {
		assertEquals("Zero test failed", 0.0, TipUtilities.calcTip(0.0, 15), 0.01);
	}

	@Test
	public void testWholeNum() {
		assertEquals("Whole number test failed", 15.0, TipUtilities.calcTip(100, 15), 0.01);
	}

	@Test
	public void testDecimal() {
		assertEquals("Decimal test failed", 3.0, TipUtilities.calcTip(20.0, 15), 0.01);
	}

	@Test
	public void testHundred() {
		assertEquals("Tip doesn't match basis", 20.0, TipUtilities.calcTip(20.0, 100), 0.01);
	}

	@Test
	public void testBasisDecimal() {
		assertEquals("Wrong calc for decimal basis", .25, TipUtilities.calcTip(0.50, 50), 0.01);
	}

	@Test
	public void testRoundSub() {
		assertEquals("Subtip test failed", 0.25, TipUtilities.round(0.25, 0.25), 0.01);
	}

	@Test
	public void testNearestCent() {
		assertEquals("Nearest cent fails", 12.75, TipUtilities.round(12.75, 0.01), 0.01);
	}

	@Test
	public void testDollar() {
		assertEquals("Round to the nearest dollar failed", 13.00, TipUtilities.round(12.66, 1.0), 0.01);
	}

	@Test
	public void testTen() {
		assertEquals("Closest .10 failed", 1.10, TipUtilities.round(1.11, .10), 0.01);
	}

	@Test
	public void testFifty() {
		assertEquals("The nearest .50 fails", 2.5, TipUtilities.round(2.44, 0.50), 0.01);
	}

	@Test
	public void testSubTipDecimal() {
		assertEquals("Bad calc when subtip is a decimal", .50, TipUtilities.round(.44, .50), 0.01);
	}

	@Test
	public void testToString() {
		assertEquals("The string output doesn't match the expected string", "15.56", TipUtilities.toString(15.5556, 2));
	}

	@Test
	public void testZeroDecimalPlaces() {
		assertEquals("The string output doesn't match the expected string", "12", TipUtilities.toString(12, 0));
	}

	@Test
	public void testMoreThanTwo() {
		assertEquals("The string output doesn't match the expected string", "20.87325",
				TipUtilities.toString(20.873248247, 5));
	}

	@Test
	public void testDecimalRoundingToWholeNum() {
		assertEquals("String did not round properly", "21", TipUtilities.toString(20.873248247, 0));
	}

	@Test
	public void testIrrationalRounding() {
		assertEquals("String did not round properly", "16.79", TipUtilities.toString(16.788888888888888, 2));
	}
}
