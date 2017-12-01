import java.util.*;

public class Teams 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numProbs = in.nextInt();
		int output = 0;
		
		//Each problem
		for(int i = 0; i < numProbs; i++)
		{
			int sum = 0;
			
			for(int j = 0; j < 3; j++)
			{
				sum += in.nextInt();
			}
			
			if(sum >= 2)
			{
				output++;
			}
		}
		
		System.out.println(output);
	}
}
