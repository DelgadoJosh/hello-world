// Joshua Delgado and Sarinda Samarasinghe
// 9/1/17
// To calculate if a given deck of cards has a win or no-win situation for the player
// in a game of blackjack

import java.util.Scanner;
import java.util.ArrayList;

public class BlackJack 
{
	public static void main(String[] args)
	{
		//Declare variables
		Scanner in = new Scanner(System.in);
		ArrayList inputArray = new ArrayList();
		boolean notJoker = true;
		
		//Reads input and stores in array inputArray
		while(notJoker)
		{
			String currentWord = in.next();
			inputArray.add(currentWord);
			if(currentWord.equals("JOKER"))
				notJoker = false;
		}
		
		//Create outputArray
		boolean[] outArray = new boolean[inputArray.size()];
		
		//Processing
		for( int i = 0; i < inputArray.size(); i++)
		{
			char[] deck = inputArray.get(i).toString().toCharArray();
			outArray[i] = hasWin(deck);
		}
		
		//Output
		for(int i = 0; i < inputArray.size()-1; i++)
		{
			if(outArray[i])
			{
				System.out.println("Yes");
			} else if(!outArray[i])
			{
				System.out.println("No");
			} else
			{
				System.out.println("Error");
			}
		}
		
		in.close();
	}
	
	
	
	//Calculates score if given a Character
	public static int score(char inChar)
	{
		if(inChar == 'T' || inChar == 'J' || inChar == 'Q' || inChar == 'K')
		{
			return 10;
		} else if(inChar == 'A')
		{
			return 1;
		} 
		return ((int)inChar-48);
	}
	
	//Calculates player score given a CharacterArray of the Deck of Cards and number of cards dealt
	public static int playerScore(char[] inArray, int dealt)
	{
		int score = score(inArray[0]) + score(inArray[2]);
		boolean hasAce = false;
		
		if(inArray[0] == 'A' || inArray[2] == 'A')
		{
			hasAce = true;
		}
		
		for(int i = 4; i < dealt+4; i++)
		{
			if(inArray[i] == 'A') //Checks if aces are in the deck
			{
				hasAce = true;
			}
			
			score += score(inArray[i]);
		}
		if(hasAce && score <= 11)
		{
			score += 10;
		}
		return score;
		
	}
	
	//Calculates Dealer score given a CharacterArray of the Deck of Cards and number of cards dealt
	public static int dealerScore(char[] inArray, int dealt)
	{
		int score = score(inArray[1]) + score(inArray[3]);
		int index = dealt+4;
		
		//Accounts for ace  [THIS IS WHERE ERROR IS]... Dangit
		if(inArray[1] == 'A' || inArray[3] == 'A')
		{
			score+= 10;
		}
		
		while(score < 17 && index < inArray.length)
		{
			if(inArray[index] == 'A' && score <= 11)
			{
				score += 10;
			}
			score += score(inArray[index]);
			index++;
		}
		return score;
	}
	
	//Input: Deck of cards in character array
	//Output: if there is a win situation
	public static boolean hasWin(char[] inArray)
	{
		boolean gameContinue = true;
		int cardsDealt = 0;
		boolean gameWon = false;
		
		//Goes through the different possibilities
		while(gameContinue)
		{
			int playerScore = playerScore(inArray, cardsDealt);
			int dealerScore = dealerScore(inArray, cardsDealt);
			
			if(playerScore > 21) //If player busts, stop looping and player lose
			{
				gameContinue = false;
				gameWon = false;
			}else if(dealerScore > 21) //If Dealer busts, player wins
			{
				gameContinue = false;
				gameWon = true;
			}else if(playerScore == 21) //If player gets blackjack 
			{
				gameContinue = false;
				gameWon = true;
			}else if(playerScore >= dealerScore)
			{
				gameContinue = false;
				gameWon = true;
			}
			cardsDealt++;
		}
		
		return gameWon;
	}
}
