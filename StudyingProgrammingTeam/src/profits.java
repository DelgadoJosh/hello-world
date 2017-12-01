import java.util.Scanner;

public class profits 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		while( true )
		{
			int numDays = in.nextInt();
			if(numDays == 0)
			{
				break;
			}
			
			int profits[] = new int[numDays];
			
			for(int i = 0; i < numDays; i++)
			{
				profits[i] = in.nextInt();
			}
			
			//Iterates through array and has cumulative sum
			//Calculates the maximum cumulative subsequent sum
			//Given two properties of the array.
			int max = profits[0];
			int sum = 0, temp = 0, start, end;
			for(int i = 0; i < numDays; i++)
			{
				sum += profits[i];
				if(sum > max)
				{
					max = sum;
					start = temp;
					end = i;
				}
				if(sum < 0)
				{
					temp = i + 1;
					sum = 0;
				}
				
			}
			//There will be an error with the start/end if all numbers are negative
			
			System.out.println(max);
		}
		
	}
}
