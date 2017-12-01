import java.util.*;

public class CoinChangeProblem 
{
	static long[] dp;
	static int[] coins;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int valueWanted = in.nextInt();
		int numCoins = in.nextInt();
		coins = new int[numCoins];
		dp = new long[251];  //Max value to be checked is 250
		Arrays.fill(dp, -1);
		
		for(int i = 0; i < numCoins; i++)
		{
			coins[i] = in.nextInt();
		}
		
		long output = go(valueWanted);
		
		print(dp);
		
		System.out.println(output);
	}
	
	//Recursive function
	// Oh s**t. This is permutation, not combination. f***
	static long go( int valueWanted)
	{		
		//Base Case: 0 has 1 way of doing so. Can simply change the dp table to do so
		if(valueWanted == 0) return 1;
		
		//Uses dp table if there is a value there
		if(dp[valueWanted] != -1)
			return dp[valueWanted]; //Or return 1. Don't want duplicates.
		
		
		long totalCount = 0;
		for(int i = 0; i < coins.length; i++) //i< valueWanted, not coins.length. Ho
		{
			//System.out.println("Now calling valueWanted = " + valueWanted + " for coinValue = " + coins[i]);
			if( (valueWanted-coins[i]) >= 0)
			{
				totalCount += go( valueWanted - coins[i]);
				//System.out.println("go(valueWanted - coins[" + i + "]) = " + go( valueWanted - coins[i]));
			}
		}
		
		dp[valueWanted] = totalCount;
		
		return totalCount;
	}
	
	static void print(long[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}

/*

=4
4 3
1 2 3



=5
10 4
2 5 3 6




 */


