import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test case for the Game class and all of its methods
 * 
 * @author Eric Wojcik
 * @version 28 March 2017
 */
public class TestChips {

	@Test(expected = IllegalArgumentException.class)
	public void testTooSmallPile() {
		Game chips = new Game(2);
	}

	@Test
	public void testContructor() {
		Game chips = new Game(4);
		Game chips02 = new Game(8);
		Game chips03 = new Game(45);
	}

	@Test
	public void testPileSizeGetter() {
		Game chips = new Game(4);
		assertEquals(4, chips.getPile());
	}

	@Test
	public void testLimitGetter() {
		Game chips = new Game(4);
		assertEquals(3, chips.getLimit());
	}

	@Test
	public void testStandardRemove() {
		Game chips = new Game(16);
		chips.removeChips(4);
		assertEquals(12, chips.getPile());
		assertEquals(8, chips.getLimit());
	}

	@Test
	public void testMoreComplexRemove() {
		Game chips = new Game(10);
		chips.removeChips(4);
		assertEquals(6, chips.getPile());
		assertEquals(6, chips.getLimit());
	}

}
