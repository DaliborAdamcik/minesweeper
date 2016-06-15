/**
 * 
 */
package minesweeper;

//import java.util.Random;
//import static org.junit.Assert.*;

import org.junit.Test;


import junit.framework.TestCase;

/**
 * @author Študent
 *
 */
public class TestField extends TestCase {

	private static int row;
	private static int col;
	private static int mines;
	private static minesweeper.core.Field field = null;
	/**
	 * @param name
	 */
	public TestField(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link minesweeper.core.Field#Field(int, int, int)}.
	 */
	@Test
	public final void testField() {
		java.util.Random ra = new java.util.Random();
		
		do{
			row= ra.nextInt(500);
		} while(row<2);
		do{
			col= ra.nextInt(500);
		} while(col<2);
		do{
			mines= ra.nextInt(row*col);
		} while(mines<2);
		
		assertNull(field);
		
//		field = new minesweeper.core.Field(row, col, -1);
		field = new minesweeper.core.Field(row, col, mines);
		
		assertNotNull(field);
	}

	/**
	 * Test method for {@link minesweeper.core.Field#getRowCount()}.
	 */
	public final void testGetRowCount() {
		assertEquals(row, field.getRowCount());
	}

	/**
	 * Test method for {@link minesweeper.core.Field#getColumnCount()}.
	 */
	public final void testGetColumnCount() {
		assertEquals(col, field.getColumnCount());
	}

	/**
	 * Test method for {@link minesweeper.core.Field#getMineCount()}.
	 */
	public final void testGetMineCount() {
		assertEquals(mines, field.getMineCount());
	}

	/**
	 * Test method for {@link minesweeper.core.Field#getTile(int, int)}.
	 */
	public final void testGetTile() {
		int minec = 0;
		int cluec = 0;
		for(int r = 0; r<field.getRowCount();r++)
			for(int c = 0; c<field.getColumnCount();c++)
			{
				minesweeper.core.Tile tile =field.getTile(r, c);
				assertNotNull(tile);
				
				assertEquals(tile.getState(), minesweeper.core.Tile.State.CLOSED);
				
				if(tile instanceof minesweeper.core.Clue)
					cluec++;

				if(tile instanceof minesweeper.core.Mine)
					minec++;
			}
		assertEquals(mines, minec);
		assertEquals(row*col, minec+cluec);
		assertEquals(row*col-minec, cluec);
	}

}
