package minesweeper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import minesweeper.BestTimes.PlayerTime;

public class BestTimesTest {
	private static BestTimes best = null;
	private static ArrayList<String> names = new ArrayList<>();
	
	@Before
	public void setUp() throws Exception {

		if(best!=null)
			return;
		
		best = new BestTimes();
		assertNotNull("An object <BestTimes> was not initialized properly.");
		assertNotNull("An object <names> was not initialized properly.");
		
		// we need in initialization create a list of random names (to do some checks)
		Random rnd = new Random();
		int numtest = 50+rnd.nextInt(51);

		System.out.printf("> test(s) examines fully random %d items.\r\n", numtest);
		for(int c=0;c<numtest;c++)
			names.add(genName(String.format("%3d_", c+1)));
	}

	@Test
	public final void testIterator() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAddPlayerTime() {
		Random rnd = new Random();
		
		int c = 0;
		int numtest = names.size();
		for(String name: names)
		{
			int time = rnd.nextInt(50)+1;
			System.out.printf("\t%-25s (%3d)\t->\t", name, time);
	
			if(c<numtest-1) // fail test for last item
				best.addPlayerTime(name, time);
			
			boolean compared = false;
			for(PlayerTime p : best)
			{
				if(p.getName().compareTo(name)==0) // we found added player
				{
					compared= true;
					assertEquals("Bad time assigned to player", time, p.getTime());
					System.out.println("OKi");
				}
			}
			
			if(c<numtest-1) // ignore in fail test
			{	
				if(!compared)
					System.out.println("E R R O R");
				assertTrue("Player not found by name. ", compared);
			}
			else // fail test resolution
			{
				if(!compared)
					System.out.println("OK (FAIL test)");
				else
					System.out.println("NOT (OK FAIL test)");
					
				assertFalse("Player found by name, bud not added. ", compared);
			}
			
			c++;
		}
	}

	/**
	 * Check only "names" into toString();
	 */
	@Test 
	public final void testToStringNAMES() {  
		String ou = best.toString();
		assertNotEquals("Unitialized / call me after testAddPlayerTime", "<Empty>", ou);

		int c=0; 
		
		for(String name: names)
			if(ou.contains(name))
				c++;
		
		System.out.printf("> testToStringNAMES checks %d items and found %d.\n", names.size(), c);
		
		assertEquals("No items found in serialize", names.size(), c);
	}

	@Test
	public final void testReset() {
		fail("Not yet implemented"); // TODO
	}
	
	/**
	 * Generates random string with length in range 5..15
	 * Includes Upper and Lower case charaters in random order
	 * @return Random string
	 */
	private String genName(String _prefix)
	{
		Random rnd = new Random();
		int dlen = rnd.nextInt(16)+5;
		StringBuilder ret = new StringBuilder();
		
		do
		{
			switch(rnd.nextInt(2))
			{
				case 1: ret.append((char) ('a'+rnd.nextInt('z'-'a'+1))); break;
				default: ret.append((char) ('A'+rnd.nextInt('z'-'a'+1))); break;
			}
		}
		while(ret.length()<dlen);
		
		ret.insert(0, _prefix);
		return ret.toString();
	}
	
}
