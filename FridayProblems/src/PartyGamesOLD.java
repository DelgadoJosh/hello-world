//Josh Delgado
//Sarinda Samarsinghe
//10-27-17
//PartyGames file
//This outputs the shortest and first alphabetical string that has half of the input strings
//be before or equal to it, and exactly half be after it.

import java.util.*;

public class PartyGamesOLD 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		while( true)
		{
			//Declares variable for number of guests
			int numGuests = in.nextInt();
			
			//Breaks the loop if the number of guests is zero
			if(numGuests == 0)
			{
				break;
			}
			
			//Creates array for the guests
			String[] guest = new String[numGuests];
			
			for(int i = 0; i < numGuests; i++)
			{
				String name = in.next();
				
				guest[i] = name;
			}
			
			//Sorts the array
			Arrays.sort( guest );
			
			//Index of the string immediately after halfway point;
			int halfway = numGuests/2;
			
			//Since all other strings are guaranteed before and after, only need to worry about
			//the halfway words. 
			char[] beforeHalf = guest[halfway-1].toCharArray();
			char[] afterHalf = guest[halfway].toCharArray();
			String wordBefore = guest[halfway-1];
			String wordAfter = guest[halfway];
			
			//Declares variables
			String output = "";
			int counter = 0;
			
			//This processes through each letter of the words
			while(true)
			{
				// If the first string is contained in the second string completely, break it
				if(counter == beforeHalf.length-1)
				{
					output = wordBefore;
					break;
				}
				
				//If both words have the same letter at this counter index
				//Add the current letter being compared
				if(beforeHalf[counter] == afterHalf[counter] )
				{
					output = output + beforeHalf[counter];
				}
				
				//If the words differ at this letter, add the first letter after the beforeHalf letter
				//Break since they now differ
				else
				{					
					char nextLetter = (char)((int)beforeHalf[counter] +1);
					output = output + nextLetter;
					
					/*//Redundant
					if(counter == beforeHalf.length)
					{
						output = wordBefore;
						break;
					}*/
					
					//Considers exception if by changing it to the next letter matches the word after
					if(output.equals(wordAfter))
					{
						if(counter == beforeHalf.length-1)
						{
							output = wordBefore;
							break;
						}
						
						
						//If the next letter makes it into the word that follows it
						counter++;
						
						//Accounts for if the end of a word is z, which has no "next letter"
						//Goes through every letter remaining to see if they are still z
						while( beforeHalf[counter] == 'Z')
						{
							if(counter == beforeHalf.length-1)
								break;
							counter++;
						}
						
						//Accounts for if the word ends in z, after a sequence of z's
						//Also accounts for if the entire word is needed
						if(counter == beforeHalf.length-1)
						{
							output = wordBefore;
							break;
						}
						
						//Adds the next letter, if there is one.
						//The above loop should guarantee that it is not z
						nextLetter = (char)((int)beforeHalf[counter] +1);
						output = wordBefore.substring(0, counter) + nextLetter;
						break;
					}
					
					break;
				}
				
				
				counter++;
				
			}
			
			
			//Yeah, this was before I realized I can just use a character array. Derp -_-
			/*
			while( true )
			{
				if(beforeHalf.length() == 1)
				{
					output = output + beforeHalf;
					break;
				}
				
				//Gets first letter of both words.
				String b1 = beforeHalf.substring(0, 1);
				String a1 = afterHalf.substring(0, 1);
				
				//Cuts off first letter of the word
				beforeHalf = beforeHalf.substring(1);
				afterHalf = afterHalf.substring(1);
				
				//If first letter of both words are the same, add to the output
				if(b1.equals(a1))
				{
					output = output + b1;
					continue;
				}
				
				else
				{
					//If there is a difference between the letters, add the first letter after b1.
					output = output + ( (char)((int)b1+1) ); 
					break;
				}
				
				
			} */
			
			System.out.println(output);
			
			
		}
	}
}
