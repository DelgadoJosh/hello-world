import java.lang.Math; 
import java.util.*;
/*
public class magical3 
{
	public static final int MAX = 10000;//Integer.MAX_VALUE;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int input = in.nextInt();
		
		//int[] smallestBase = smallestBase( MAX );
		
		//int output = smallestBase[input];
		
		//int output = findSmallestBase(input); //Character method. Times out :(
		
		int output = findSmallestBase(input, 1); //For using math method
		
		System.out.println(output);
		
	}
	
	
	//Attempting to find smallest base
	// Using idea that all prime number multiples + 3 = smallest base for that number. Woot. Going to essentially do a
	// Cumulative thing. Array that produces ALL smallest bases with ending in 3, ignoring 0's.
	// Thing is, it doesn't ignore the 0's at the end, I believe... So back to the drawing board.
	public static int[] smallestBase(int max)
	{
		//max-= 10; //Ugh, out of memory error. :(
		boolean[] isPrime = primeSieve(max);
		//System.out.println(isPrime[13]);
		
		int[] output = new int[max]; //Stores the minimum base needed for the numbers
		Arrays.fill(output, -1);
		
		for(int i = 4; i < max; i++)
		{
			if(isPrime[i])
			{
				//System.out.println("Testing i = " + i);
				for(int j = i; j < max-3; j+=i) // J is all the multiples of the prime number, should j < max, or j < max-3?
				{
					//If doesn't have a lower base
					if(output[j+3] == -1)
					{
						output[j+3] = i; //i = prime number.
					}
				}
			}
		}
		
		//Debugging
		for(int i = 0; i < max; i++)
		{
			//System.out.println("output[" + i + "] = " + output[i]);
			//System.out.println("isPrime[" + i + "] = " + isPrime[i]);
		}
		
		return output;
	}
	
	// Attempts to use math to find the smallest base. 
	public static int findSmallestBase(int input, int dud)
	{
		int base = 4; //Either start at 4 or 2. Pretty sure it'll be 4...
		int output = 0;
		boolean stop = false;
		
		
		
		
		while(!stop)
		{
			//System.out.println("Check");
			//System.out.println("Base " + base + ": ");
			if(input%base == 3)
			{
				output = base;
				break;
			}
			
			int power = 1;
			//Accounts for all the zeroes.
			while(input % Math.pow(base,  power) == 0)
			{
				//System.out.println("Power: " + power + " Now checking input%(" + base + "^" + (power+2) + ") / 3*(" + base + "^" + (power+1) +")");
				//if(input / Math.pow(base,  power+1) == 3) //Math.pow(3, power)) if( (input % Math.pow(base,  power+2)) / 3*Math.pow(3, power+1) == 0)
				//if( (input % Math.pow(base,  power+2)) / (3*Math.pow(base, power+1)) == 1)
				if( (input % Math.pow(base,  power+2)) / 3 == Math.pow(base, power+1))
				{
					output = base;
					stop = true;
					break;
				}
				power++;
				
				
			}
				
			
			
			if(input% Math.pow(base, power) == 3)
			{
				output = base;
				break;
			}
			
			
			base++;
		} 
		
		return output;
	}
	
	//Attempting to use character arrays to find the smallest base.
	//However, it's pretty darn slow, literally going through EVERY SINGLE NUMBER, starting at 2. Maybe I should start at 4? Probably.
	public static int findSmallestBase(int input)
	{
		int base = 4;
		int output = 0;
		boolean stop = false;
		
		/*///Just testing to see what happens if it's above base 9+26(no letter to represent it)
		/*
		base = 75;
		input = 73+75;
		char[] cArray = Integer.toString(input, base).toCharArray();
		System.out.println("Base: " + base + " - " + Arrays.toString(cArray));
		stop = true;
		*/
		
		/*
		while(!stop)
		{
			
			char[] cBArray = Integer.toString(input, base).toCharArray();
			System.out.println("Base: " + base + " - " + Arrays.toString(cBArray));
			//System.out.println(Arrays.toString(cBArray) + " cBArray[3] = " + cBArray[3]);
			//System.out.println(Arrays.toString(cBArray) + " ");
			
			int i = cBArray.length-1;
			while( cBArray[i] == '0')
			{
				i--;
			}
			
			if( cBArray[i] == '3')
			{
				//System.out.println("cBArray[i] = " + (int)cBArray[i] + " (int)'3' = " + (int)'3');
				//System.out.println("Ends in 3 at index " + i);
				output = base;
				stop = true;
			}
			
			/*
			if( ((int)cBArray[i]) == ((int)'3')  ); //I don't know why this isn't working. Nevermind. The bloody semicolon. I'm disappointed. You idiot.
			{
				System.out.println("cBArray[i] = " + (int)cBArray[i] + " (int)'3' = " + (int)'3');
				System.out.println("Ends in 3 at index " + i);
				output = base;
				stop = true;
			}*/
			
			/*
			base++;
			
			if(base > 2000) break;
		} 
		
		return output;
	}
	
	// Generates primeSieve of size size
	public static boolean[] primeSieve(int size)
	{
		boolean[] isPrime = new boolean[size];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i = 2; i < size; i++)
		{
			if(isPrime[i])
			{
				for(int j = 2*i; j < size; j+=i)
				{
					isPrime[j] = false;
				}
			}
		}
		
		return isPrime;
	}
	
	
	
	
}

/*
11			//11
42			//13
9876		//9
8			//5
2000000 	//5 //46875 + 1953125  or 4?
200000 		//4
20000  		//19997? Breaks cArray... huh.

*/
