import java.util.*;

public class NextRound 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		//Wow my code is disgusting. Time to change it up
		
		int numContestants = in.nextInt();
		int place = in.nextInt();
		int[] values = new int[numContestants];
		int output = place;
		
		//Input every single contestant
		for(int i = 0; i < numContestants; i++)
		{
			values[i] = in.nextInt();
		}
		
		
		
		//PROCESSING
		//If the place equals the number of contestants, basically checks last place to ensure it's > 0.
		//Is this step necessary?
		/*
		if(values[place-1] > 0 && place == numContestants)
		{
			output = numContestants;
		} 
		
		//If every contestant gets a non-positive score.
		else*/ 
		if( values[0] <= 0)
		{
			output = 0;
		}
		
		// Now checks if the value of the person in _th place is positive
		else if(values[place-1] > 0)
		{
			for(int i = place-1; i < numContestants; i++)
			{
				if(values[i] == values[place-1])
				{
					output = i+1;
				}
			}
		} 
		
		//Since the value is not positive, has to check to the left for first positive answer
		else
		{
			for(int i = place-1; i >= 0; i--)
			{
				if(values[i] > 0)
				{
					output = i+1;
					break;
				}
			}
		}
		
		System.out.println(output);
		
		
		
		
		
		
		//OLD CODE
		/*
		//Processing
		if(values[numContinue - 1] < 0)
		{
			//Decreases the number that continue that are not positive 
			while(numContinue > 0 && numContinue < numContestants && values[numContinue-1] <= 0)
			{
				numContinue -= 1;
			}
		}
		
		//Accounts for if the place is the same
		if(numContinue > 0 && numContinue < numContestants && values[numContinue-1] > 0)
		{
			int minScore = values[numContinue-1];
			while(numContinue-1 < numContestants && numContinue < numContestants && values[numContinue] == minScore)
			{
				numContinue += 1;
			}
		}
		
		//Checks if last number is = to the minimum score needed
		if(numContinue > 0 && numContinue < numContestants && values[numContestants-1] == values[numContinue-1])
		{
			numContinue = numContestants;
		}
		
		
		
		System.out.println(numContinue);
		*/
	}
}
