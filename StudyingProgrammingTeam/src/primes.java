import java.util.*;

public class primes 
{
	public static final int MAX = 10000000;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		//Generates primesieve
		boolean[] isPrime = primeSieve(MAX);
		
		int numCases = in.nextInt();
		
		//Goes through all values
		for(int i = 0; i < numCases; i++)
		{
			int num = in.nextInt();
			
			if(isPrime[num])
			{
				System.out.println("1");
			} else
			{
				System.out.println("0");
			}
		}
		
		/*
		while(true)
		{
			int num = in.nextInt();
			
			if(num == 0)
			{
				break;
			}
			
			if(isPrime[num])
				System.out.println("1");
			else
				System.out.println("0");
			
		}
		*/
		
	}
	
	public static boolean[] primeSieve(int cap)
	{
		boolean[] isPrime = new boolean[cap+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i = 2; i < (int)(Math.sqrt(cap))+1; i++)
		{
			if(isPrime[i])
			{
				for(int j = 2*i; j < cap+1; j+= i)
				{
					isPrime[j] = false;
				}
			}
		}
		
		return isPrime;
		
	}
}
