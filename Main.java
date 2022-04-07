// Name: Rayna DeJesus

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {   
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in); //Scanner for user input
        
        System.out.println("Welcome to Wordle - Java Edition!" + "\n" + "The ✖ means that the letter isn't in the word"+ "\n" + "The ● meants that the letter is in the word, but not in the right location" + "\n" + "The ✔ means the letter is in the right postion" + "\n"  + "\n" +  "Lets get started!" + "\n"); //key for the symbols
        
        File ww = new File ("wordle-words.txt");  // file is potential words used for wordle
        File d = new File ("dictionary.txt"); //file contains valid words that the user can input
        ArrayList <String> words = new ArrayList <String> ();
        ArrayList <String> words2 = new ArrayList <String> ();
				int choice;
        
        try {
        	Scanner sc = new Scanner (ww);
        	while (sc.hasNextLine())
        		 words.add(sc.nextLine());
					
        	Scanner sc2 = new Scanner (d);
        	while (sc2.hasNextLine())
        			words2.add(sc2.nextLine());
        } //gets words from the files and puts into an ArrayList
        
        catch (FileNotFoundException e){
        	System.out.println("an error occured");
        }
        
        String secret = words.get((int)(Math.random()*words.size())); //gets random word from the wordle words
        String secret2 = words.get((int)(Math.random()*words.size())); //gets another word from wordle words (if doing hard mode)

			System.out.println("Would mode would you like? Type 1 for easy mode, or type 2 for hard mode" + "\n" + "easy mode - one wordle with 6 tries" + "\n" + "hard mode - two wordles with 8 tries"); 
			choice = kb.nextInt();
			kb.nextLine(); //ask user what mode they would want

		
				wordle y = new wordle (secret.toUpperCase()); //creates an object for easy mode
        duoWordle x = new duoWordle(secret.toUpperCase(), secret2.toUpperCase()); //creates an object for hard mode

				if (choice == 1){ //easy mode
					while ((!y.isComplete()  && !y.outOfGuesses())){  //runs until out of guesses or complete
        String guess = ""; //user's input
						
				while (guess.length() != 5){
					System.out.println ("You have " + y.guessesLeft() + " guesses left. Enter your five letter word: "); //asks for user input
 				guess = kb.nextLine();	
        }
						
 			if (words2.contains(guess) && guess.length() == 5){
 				y.tryWord(guess.toUpperCase());
 				System.out.println(y); //checks to see if word is in dictionary file and it's the appropiate length. if so, it it prints the matrix
 			}
				
 			else if (!words2.contains(guess) ) {
 				System.out.println("That word is not in our system. Try again!"); //prints if the word isn't in the dictionary file
 			}			
        }
      	if (y.isComplete()) //got the right word and return tries
 				System.out.println("Congrats, your guess was correct! It took you " + (6-y.guessesLeft()) + " tries");
				else if (y.outOfGuesses()) //ran out of guess and returns secret
 			System.out.println("Sorry the game has ended! The secret word was " + y.getSecret());
				}

			
			if (choice == 2){ //repeats the same thing as easy mode w/ some changes
        while (((!x.isComplete()  || !x.oneIsComplete() || !x.twoIsComplete()) && !x.outOfGuesses())){ //same thing as easy mode, but checks to see if one of the words are guessed correctly
        	String guess = "";
        	
        	while (guess.length() != 5){
        		System.out.println ("You have " + x.guessesLeft() + " guesses left. Enter your five letter word: ");
 					guess = kb.nextLine();	
        }
 			
 			if (words2.contains(guess) && guess.length() == 5){
 				x.tryWord(guess.toUpperCase()); 
 				System.out.println(x);
				}
 			else if (!words2.contains(guess) && guess.length() == 5) 
 				System.out.println("That word is not in our system. Try again!");
        }

  	if (x.isComplete())
 					System.out.println("Congrats, your guess was correct! It took you " + (8-x.guessesLeft()) + " tries");
 		else if (x.oneIsComplete())
 				System.out.println("You got the first word! It took you " + (8-x.guessesLeft()) + " tries. The words were " + x.getSecret()); 
 		else if (x.twoIsComplete())
 				System.out.println("You got the second word! It took you " + (8-x.guessesLeft()) + " tries. The words were " + x.getSecret()); 
			//returns if one of 2 words were correct
 		else if (x.outOfGuesses())
 				System.out.println("Sorry the game has ended! The secret word was " + x.getSecret());
 
		}
	}
    }
