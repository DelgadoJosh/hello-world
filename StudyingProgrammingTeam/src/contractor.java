import java.util.*;

public class contractor 
{
	static long[][] dp;
	static int[] cost;
	static int[] pay;
	static int numJobs;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++)
		{
			numJobs = in.nextInt();
			int daysToWork = in.nextInt();
			
			//Initialize static arrays
			cost = new int[numJobs];
			pay = new int[numJobs];
			dp = new long[numJobs][daysToWork+1];
			for(int j = 0; j < numJobs; j++)
			{
				Arrays.fill(dp[j], (long)-1);
			}
			
			
			for(int j = 0; j< numJobs; j++)
			{
				cost[j] = in.nextInt();
				pay[j] = in.nextInt();
			}
			
			long max = go(0, daysToWork);
			
			//print(dp);
			
			System.out.println(max);
			
		}
		
		
		
		
	}
	
	public static long go(int index, int daysRemaining)
	{
		//Tests for out of bounds
		if(index == numJobs)
			return 0;
		if(daysRemaining <= 0) //Refuses to take value of money[index]. Since this is redundant, can be removed.
			return 0;

		//Tests for if already filled in before
		if(dp[index][daysRemaining] != -1)
			return dp[index][daysRemaining];
		
		long take = 0;
		//Will add take amount if possible
		if(cost[index] <= daysRemaining)
		{
			take = go(index+1, daysRemaining-cost[index]) + pay[index];
		}
		
		long dont = go(index+1, daysRemaining);
		
		long best = Math.max(take, dont);
		
		return dp[index][daysRemaining] = best;
		
	}
	
	public static void print(long[][] input)
	{
		for(int i = 0; i < input.length; i++)
		{
			for(int j = 0; j < input[0].length; j++)
			{
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}
}



/*
2
2 5
3 10000
4 8000
3 100
20 20000
40 50000
40 30000

1
2 5
6 500
10 4000

1
2 5
3 0
5 0

1
4 60
45 45
20 19
20 19
20 19

1
1 365
365 10


*/



