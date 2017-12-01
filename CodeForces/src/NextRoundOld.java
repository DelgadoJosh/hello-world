import java.util.*;

public class NextRoundOld 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		//Wow my code is disgusting
		
		int numContestants = in.nextInt();
		int place = in.nextInt();
		int[] values = new int[numContestants];
		int numContinue = place+1;
		
		//Input every single contestant
		for(int i = 0; i < numContestants; i++)
		{
			values[i] = in.nextInt();
		}
		
		
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
	}
}
