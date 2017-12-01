import java.lang.Math;

public class ProjectEuler3 
{
	public static void main(String[] args)
	{
		//int outputNum = 600851475143; //Oh. too big for ints... S**t. Ahh son of a...
		double outputNum = 600851475143.0;
		//double outputNum = 13195;
		outputNum = findLargestPrime(outputNum);
		System.out.println(outputNum);
	}
	
	
	public static int findLargestPrime(int input)
	{
		int factor = 2;
		while(factor < input)
		{
			if(input%factor == 0) //remainder = 0
			{
				input = input/factor;
			}
			factor+= 1;
		}
		return factor;
	}
	
	public static double findLargestPrime(double input) //So, I need to find a way to do modulus on a double, or how to find out if a double is a whole number (to determine if evenly divided). Maybe parse to a string, and check if after decimal point is a 0? Kinda rough, and may not account for precision loss, but whatever...  Also, have it locate the index of a . for finding the 0 after it. Oh wait, just use floor(double x) to get the integer right below it. I hope it'll work with it. 
	{ //I could think about this from another angle, and try to multiply up to that number somehow
		double factor = 2;
		while(factor < input)
		{
			if(input/factor == Math.floor(input/factor) )
			{
				//System.out.println("CheckA");
				//System.out.println(factor);
				input = Math.floor(input/factor);
			} else if (input/factor == Math.ceil(input/factor) )
			{
				//System.out.println("CheckB");
				input = Math.ceil(input/factor);
			}
			factor += 1;
		}
		return factor;
	}
}
