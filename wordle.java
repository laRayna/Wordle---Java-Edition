//Name: Rayna DeJesus

public class wordle {      
	private String[][]  grid; 
	private String SECRET;
	private int row;

	//initialize the instance variables
	public wordle(String s) {
		grid = new String [12][5];
		SECRET = s;
		row = 0;
		for (int r = 0; r < grid.length; r++){
			for (int c = 0; c < grid[r].length; c++){
				grid[r][c] = "-";
			}
		}
	}

		//initialize the instance variables - used for duoWorlde
		public wordle(String s, int g) {
		grid = new String [2*g][5];
		SECRET = s;
		row = 0;
		for (int r = 0; r < grid.length; r++){
			for (int c = 0; c < grid[r].length; c++){
				grid[r][c] = "-";
			}
		}
	}

	//prints symbol depending on the users input
	public void tryWord(String word) {		
		for (int col = 0; col < grid[row].length; col++){
			grid[row][col] = word.substring(col, col + 1);
			if (SECRET.indexOf(word.substring(col, col + 1)) < 0){
				grid[row+1][col] = "✖";
			}
			else if (word.substring(col, col + 1).equals(SECRET.substring(col, col + 1))){
				grid[row+1][col] = "✔";
			}
			else {
				grid[row+1][col] = "●";
			}
		}
		row = row + 2;
	}
	
	//Return true if the player has succesfully guessed the word
	public boolean isComplete()
	{
		int tries = 0;
		int r = row - 1;
		if (r > 0){
			for (String index: grid[r]){
				if (index == "✔")
					tries++;
			}
		    if (tries == 5) {
		    	return true;
			}
			return false; 
		}
		else{
			for (String index: grid[0]){
				if (index == "✔")
					tries++;
			}
		    if (tries == 5) {
		    	return true;
			}
			return false; 
			
		}
	}
	
	//Return true if the player is out of guesses
	public boolean outOfGuesses()
	{
		if (row >= grid.length){
			return true;
		}
		return false;
	}
	
	//Return the number of guess left
	public int guessesLeft()
	{
		return  (grid.length-row)/2;
	}
	
	//Return the secret word, but only if the game is complete or the player ran out of guesses
	public String getSecret()
	{
		if(isComplete() || outOfGuesses())
			return SECRET;
		else
			return "You can't have the word yet";
	}
	
	//Return a string version of the 2D array with appropriate spacing and new lines
	public String toString()
	{
		String temp="";
		for (int r = 0; r < grid.length; r++){
			for (int c = 0; c < grid[r].length; c++){
				temp = temp + grid [r][c]+" ";
			}
			temp = temp + "\n";
		}
		
		return temp;
	}
}