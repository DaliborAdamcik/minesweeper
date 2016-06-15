package minesweeper.consoleui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import minesweeper.UserInterface;
import minesweeper.core.Field;
import minesweeper.core.GameState;
//import minesweeper.core.Tile.State;

/**
 * Console user interface.
 */
public class ConsoleUI implements UserInterface {
    /** Playing field. */
    private Field field;
    
    /** Input reader. */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Reads line of text from the reader.
     * @return line as a string
     */
    private String readLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    /* (non-Javadoc)
	 * @see minesweeper.consoleui.UserInterface#newGameStarted(minesweeper.core.Field)
	 */
    @Override
	public void newGameStarted(Field field) {
        this.field = field;
        do {
            update();
            processInput();
        } while(field.getState().compareTo(GameState.PLAYING)==0);
        update();
        System.out.println("You "+field.getState());
        
    }
    
    /* (non-Javadoc)
	 * @see minesweeper.consoleui.UserInterface#update()
	 */
    @Override
	public void update() {
        for(int row = 0; row<field.getRowCount();row++)
        {
    		if(row==0)
    		{
    			int charcnt = 4+field.getColumnCount()*3;
    			StringBuilder s1 = new StringBuilder(charcnt);
    			StringBuilder s2 = new StringBuilder(charcnt);
    			s1.append("Mi  ");
    			s2.append("nes-");
    			
       			for(int col =0;col<field.getColumnCount();col++)
       			{
       				s1.append(String.format("%2d ", col));
       				s2.append("---");
       			}	
       			System.out.println(s1);
       			System.out.println(s2);
    		}

    		System.out.printf(" %c| ", row+'A');
    		
   			for(int col =0;col<field.getColumnCount();col++)
        	{
        		minesweeper.core.Tile tile = field.getTile(row, col);
        		
        		switch(tile.getState())// OPEN CLOSED MARKED
        		{
					case CLOSED:
		        		if(field.getState()!=GameState.FAILED)
						System.out.print("   ");
		        		else
		        			updatePrintTile(tile);
						break;
					case MARKED:
						{
			        		if(tile instanceof minesweeper.core.Mine)
			        			System.out.print(" X ");
			        		else
			        		if(tile instanceof minesweeper.core.Clue)
			        			System.out.print(" C ");
			        		else
			        			System.out.print(" ! ");
						}
						break;
					default:
						{
							updatePrintTile(tile);
						}
						break;
        		}
        		
        		
        	}
        	System.out.println();
        }
        
        
    }
    
    private void updatePrintTile(minesweeper.core.Tile tile)
    {
		if(tile instanceof minesweeper.core.Mine)
			System.out.print(" * ");
		else
		if(tile instanceof minesweeper.core.Clue)
			System.out.print(String.format(" %1d ", ((minesweeper.core.Clue)tile).getValue()));
		else
			System.out.print(" ! "); // null on field
    }
    
    /**
     * Processes user input.
     * Reads line from console and does the action on a playing field according to input string.
     */
    private void processInput() {
        Pattern pattern = Pattern.compile("[exh]|[om]([0-"+Integer.toString(field.getColumnCount()-1)+"])([a-"+
        		((char)('a'+field.getRowCount()-1))+"])");

        Matcher matcher;
        int badcmd = 0;
        
        do
        {
        	if(badcmd>0 && (badcmd++%3==0))
        		System.out.println("Please, type '?' for help.");
        	
        	System.out.print(">");
        	String inp = readLine().toLowerCase();
        	matcher = pattern.matcher(inp);
        }
        while(!matcher.matches());
        
        int irow=0;
        int icol=0;
        if("mo".indexOf(matcher.group(0).charAt(0))>=0)
        {
	        irow = (int)(matcher.group(2).charAt(0)-'a');
	        icol = Integer.parseInt(matcher.group(1));
        }
        
        switch(matcher.group(0).charAt(0))
        {
        	case 'x':
        	case 'e': System.out.println("Bye...");System.exit(0); break;
	    	case 'h': System.out.println("x,e:exit, h:help, m a0: mark tile A0, o b1: open tile B1");break;
	    	case 'm': field.markTile(irow, icol);break;
	    	case 'o': field.openTile(irow, icol);break;
	    	
        }
    }
}