//Name: Rayna DeJesus

public class duoWordle {
        
	private wordle one;
	private wordle two;
  private int guesses;

	//initialize the instance variablese
	public duoWordle(String first, String second) 
	{
		one = new wordle(first, 8);
		two = new wordle (second, 8);
		guesses = 8;
	}
	
	public duoWordle(String first, String second, int r) 
	{
		one = new wordle (first, r);
		two = new wordle (second, r);
		guesses = r;

	}

	// try words until complete
	public void tryWord(String word)
	{
		if (oneIsComplete() == false)
			one.tryWord(word);
		if (twoIsComplete() == false)	
			two.tryWord(word);
		guesses--;
	}

	//returns true if both wordles are complete
	public boolean isComplete()
	{
		if (one.isComplete()== true && two.isComplete() == true)
			return true;
		else
			return false; 
	}

	//returns true if wordle 1 is complete
	public boolean oneIsComplete()
	{
		if (one.isComplete() == true)
			return true;
		else
			return false;
	}

	//returns true if wordle 2 is complete
	public boolean twoIsComplete()
	{	
		if (two.isComplete() == true)
			return true;
		else 
			return false;
	}

	//returns guesses left
	public int guessesLeft()
	{
		return guesses;
	}

	//returns true if guesses are 0 
	public boolean outOfGuesses()
	{
		if (guesses == 0)
			return true; 
		else 
			return false;
	}

	//returns the secret words if game is completed
	public String getSecret()
	{
		if(outOfGuesses() || isComplete() )
			return one.getSecret()+" and  "+two.getSecret();
		else
			return "You can't have the words yet";
	}
	
	public String toString()
	{
		return "\n" + one.toString() + "\n" +  two.toString(); 
	}
}
