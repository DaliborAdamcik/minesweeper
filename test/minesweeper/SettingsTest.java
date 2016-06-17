/**
 * 
 */
package minesweeper;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Dalibor Adam��k
 *
 */
public class SettingsTest {
	private static Settings sets;
	private static int rowc;
	private static int colc;
	private static int minc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Random ran = new Random();
		rowc = ran.nextInt(49)+2;
		colc = ran.nextInt(49)+2;
		minc = ran.nextInt(rowc*colc)+1;
		sets = new Settings(rowc, colc, minc);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link minesweeper.Settings#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link minesweeper.Settings#Settings()}.
	 */
	@Test
	public final void testSettings() {
		assertNotNull("Object <Settings> create", sets);
	}

	/**
	 * Test method for {@link minesweeper.Settings#Settings(int, int, int)}.
	 */
	@Test
	public final void testSettingsIntIntInt() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link minesweeper.Settings#save()} and {@link minesweeper.Settings#load()}.
	 */
	@Test
	public final void testSaveLoad() {
		assertNotNull("Object <Settings> create", sets);
	}


	/**
	 * Test method for {@link minesweeper.Settings#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link minesweeper.Settings#getRowCount()}.
	 */
	@Test
	public final void testGetRowCount() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link minesweeper.Settings#getColumnCount()}.
	 */
	@Test
	public final void testGetColumnCount() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link minesweeper.Settings#getMineCount()}.
	 */
	@Test
	public final void testGetMineCount() {
		fail("Not yet implemented"); // TODO
	}

}
