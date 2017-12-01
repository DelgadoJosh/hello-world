import java.util.*;

public class XKCD 
{
	static ArrayList<String> output = new ArrayList<String>();
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			int length = in.nextInt();
			if(length == 42) break;
			
			System.out.println("XKCD-like name(s) of length: " + length);
						
			if(length >= 8) //If its impossible to have length of this size
			{
				System.out.println("Mostly Harmless");
			}
			
			String dud = "";
			//go(dud, length);
			
			for(int i = 0; i < 26; i++)
			{
				char curC = (char)(i + (int)'A');
				String temp = "" + curC;
				if(isAllowed(curC)) //Dumb line to forget
				{
					go(temp, length);
				}
			}
			Collections.sort(output);
			
			for(int i = 0; i < output.size(); i++)
			{
				System.out.println(output.get(i));
			}
			
			output.clear();
			
			
			
			
		}
		System.out.println("The answer to life, the universe and everything!");
		
	}
	
	
	// Second attempt. Stupidly flipped it by accident
	// And don't forget to swap the last two letters
	public static void go(String currentSequence, int endLength)
	{
		int length = currentSequence.length();
		int currentIndex = 0;
		if(length != 0) 
			currentIndex = currentSequence.charAt(length-1) - 'A';
		
		if( totalValue(currentSequence) > 42)
		{
			return;
		}
		
		if(length == endLength)
		{
			if(totalValue(currentSequence) == 42)
			{
				if(endLength != 2) //Now it's being sorted, that's optional
				{
					currentSequence = swapLastTwo(currentSequence);
				}
				output.add(currentSequence.toLowerCase());
				//System.out.println( currentSequence.toLowerCase() );
			}
			return;
		}
		
		int start = 0;
		int end = currentIndex;
		if(endLength == 2 )//|| length == endLength-1)
		{
			start = currentIndex+1;
			end = 26;
			/*
			for(int i = currentIndex+1; i < 26; i++)
			{
				char tempC = (char)(i + 'A');
				String temp = currentSequence + tempC;
				if( isAllowed(tempC) )
				{
					go(temp, endLength);
				}
			}*/
		} 
		
		for(int i = start; i < end; i++)
		{
			char tempC = (char)(i + 'A');
			String temp = currentSequence + tempC;
			if( isAllowed(tempC) )
			{
				go(temp, endLength);
			}
		}

		
		
		
	}
	
	public static int totalValue(String input)
	{
		int output = 0;
		for( int i = 0; i < input.length(); i++)
		{
			output += (int)(input.charAt(i) ) - 'A' +1 ;
		}
		
		return output;
	}
	
	
	//Returns if the character is allowed for 
	public static boolean isAllowed(char c)
	{
		return !(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y' );
	}
	
	//Swaps last two letters
	public static String swapLastTwo(String input)
	{
		int length = input.length();
		String temp = input.substring(0,length-2) + input.charAt(length-1) + input.charAt(length-2);
		return temp;
	}
	
	
	
	/*
	public static void go(int[] currentSequence, int endLength)
	{
		int length = currentSequence.length;
		if(currentSequence.length == endLength)
		{
			printArray(currentSequence);
			return;
		}
		
		if(notInBounds(currentSequence[length-1]) )
			return;
		
		for(int i = currentSequence[length-1]+1; i < currentSequence.length; i++)
		{
			
		}
		
	}
	*/
	
	
}

/*
Vowels are: A E I O U Y
1, 5, 9, 15, 21, 25
Currently thinking to stay in integers
Maybe start from end and go to beginning?
Well, this is brute force...
So I can just hardCode everyone
Stop it if it exceeds 42

Maybe start at the last letter, and begin with 42-NumLetters
Hopefully it would run faster
Then it would decrease
But alphabetical order
Hmm... Could do a sort, but it might explode. Like a lot.
But actually, it probably shouldn't

Hmm...

If building from end to beginning
go( currentString, currentValue, end)
currentString.length = index
for Loop will begin at ASCII value at end+1


If building from beginning to end
begin @ 42-Length (length = endLength)
if( 


Ya know what, just brute force it
begin @ 1, go up

How to check if it's "Mostly Harmless?"
Currently know All > 28 is harmlesss
All > 26 is harmless
All > 26-6 is harmless (6 vowels)

In my testing all >=8 are harmless



*/

/*
Post finished: Goodness, this was disguisting and disorganized.
First off, get the caps right
Secondly, maybe not put it in an array to sort it.
I tried creating it in order, but that was gross due to the swappage
 */


