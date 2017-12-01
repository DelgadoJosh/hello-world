//Josh Delgado
//Sarinda Samarasinghe
//10-27-17
//PartyGames file
//This outputs the shortest and first alphabetical string that has half of the input strings
//be before or equal to it, and exactly half be after it.

import java.util.*;

public class PartyGames 
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
				//Then the loop will continue to the next letter.
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
						
						//Accounts for if the end of a word is Z, which has no "next letter"
						//Goes through every letter remaining to see if they are still Z
						//So it essentially skips all 'Z's
						while( beforeHalf[counter] == 'Z' || beforeHalf[counter] == 'z') //Although I don't need to check if it's lower case z, still nice to check
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
				
				//Update counter var
				counter++;
				
			}
			
			
			
			System.out.println(output);
			
			
		}
	}
}
