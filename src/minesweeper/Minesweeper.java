package minesweeper;

import minesweeper.consoleui.ConsoleUI;
import minesweeper.core.Field;

/**
 * Main application class.
 */
public class Minesweeper {
    /** User interface. */
    private UserInterface userInterface;
    private long startMillis;
    private BestTimes bestTimes = new BestTimes(); 
    private static Minesweeper instance;
	private Settings setting;
 
    /**
     * Constructor.
     */
    private Minesweeper() {
        instance = this;
        setting = Settings.load();
        
/*        btTest();
        System.exit(0);*/
        userInterface = new ConsoleUI();
        
        Field field = new Field(8, 8, 10);
        startMillis = System.currentTimeMillis();
        userInterface.newGameStarted(field);
    }

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        new Minesweeper();
    }
    
    public int getPlayingSeconds()
    {
    	long time =(System.currentTimeMillis() - startMillis); 
    	return (int)(time / 1000);
    }
    
    public BestTimes getBestTimes()
    {
    	return bestTimes;
    }
    
    public static Minesweeper getInstance()
    {
    	return instance;
    }
    
    public void btTest() // toto potom zmazat, zadanie to nevyzaduje, len na testovacie ucely sa to pouziva
    {
        bestTimes.addPlayerTime("Jano", 10);
        bestTimes.addPlayerTime("Peter", 5);
        bestTimes.addPlayerTime("Jozef", 18);
        bestTimes.addPlayerTime("Juraj", 9);
        
        System.out.println("sor:"+bestTimes.toString());
        bestTimes.reset();
        System.out.println("res:"+bestTimes.toString());
    }

	public Settings getSetting() {
		return setting;
	}

	public void setSetting(Settings setting) {
		this.setting = setting;
		this.setting.save();
	}
}
