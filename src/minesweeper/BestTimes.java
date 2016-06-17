package minesweeper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

/**
 * Player times.
 */
public class BestTimes implements Iterable<BestTimes.PlayerTime> {
    /** List of best player times. */
    private List<PlayerTime> playerTimes = new ArrayList<PlayerTime>();

    /**
     * Returns an iterator over a set of  best times.
     * @return an iterator
     */
    public Iterator<PlayerTime> iterator() {
        return playerTimes.iterator();
    }

    /**
     * Adds player time to best times.
     * @param name name ot the player
     * @param time player time in seconds
     */
    public void addPlayerTime(String name, int time) {
        PlayerTime player = new PlayerTime(name, time);
    	playerTimes.add(player);
    	Collections.sort(playerTimes);
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object
     */
    public String toString() {
        Formatter f = new Formatter();
        try
        {
	        Iterator<PlayerTime> pl = this.playerTimes.iterator();
	        int c=1;
	        while (pl.hasNext()) {
				PlayerTime player = (PlayerTime) pl.next();
				f.format("%d. %3d %s\n", c, player.getTime(), player.getName());
				c++;
			}
	        
	        if(c==1)
	        	f.format("<Empty>");
	
	        return f.toString();
        }
        finally
        {
        	f.close();
        }
    }
    
    public void reset()
    {
    	playerTimes.removeAll(playerTimes);
//    	playerTimes = new ArrayList<PlayerTime>();
    }

    /**
     * Player time.
     */
    public static class PlayerTime  implements Comparable<PlayerTime> {
		/** Player name. */
        private final String name;

        /** Playing time in seconds. */
        private final int time;

        /**
         * Constructor.
         * @param name player name
         * @param time playing game time in seconds
         */
        public PlayerTime(String name, int time) {
            this.name = name;
            this.time = time;
        }
        
        public int compareTo(PlayerTime o)
        {
        	return this.getTime() - o.getTime();
        }

        public String getName() {
			return name;
		}

		public int getTime() {
			return time;
		}
    }
}
