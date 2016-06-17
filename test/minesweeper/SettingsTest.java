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
 * @author Dalibor Adamèík
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
		assertEquals("Invalid hashcode", sets.hashCode(), rowc*colc*minc);
	}

	/**
	 * Test method for {@link minesweeper.Settings#save()} and {@link minesweeper.Settings#load()}.
	 */
	@Test
	public final void testSaveLoad() {
		try
		{
			sets.save();
		}
		catch(Exception e)
		{
			assertFalse("Save: "+e.getMessage(), true);
		}
		
		Settings loaded = null;
		try
		{
			loaded = Settings.load();
		}
		catch(Exception e)
		{
			assertFalse("Load: "+e.getMessage(), true);
		}

		assertNotNull("No setting loaded by Class", loaded);
		assertEquals("No rowcount match",loaded.getRowCount(), rowc);
		assertEquals("No colcount match",loaded.getColumnCount(), colc);
		assertEquals("No minecount match",loaded.getMineCount(), minc);
	}


	/**
	 * Test method for {@link minesweeper.Settings#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		Settings se2t = new Settings(rowc, colc, minc);
		assertTrue("Object not equals", sets.equals(se2t));
	}

	/**
	 * Test method for {@link minesweeper.Settings#getRowCount()}.
	 */
	@Test
	public final void testGetRowCount() {
		assertEquals("No rowcount match", sets.getRowCount(), rowc);
	}

	/**
	 * Test method for {@link minesweeper.Settings#getColumnCount()}.
	 */
	@Test
	public final void testGetColumnCount() {
		assertEquals("No colcount match",sets.getColumnCount(), colc);
	}

	/**
	 * Test method for {@link minesweeper.Settings#getMineCount()}.
	 */
	@Test
	public final void testGetMineCount() {
		assertEquals("No minecount match",sets.getMineCount(), minc);
	}

	/**
	 * Test method for predefined setting BEGINNER
	 */
	@Test
	public final void testGetMineCount() {
		Settings beg = Settings.BEGINNER;
		
		
	}
}
