import java.util.*;

public class Tram 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numStops = in.nextInt();
		int max = 0;
		int currentNumPeople = 0;
		
		for(int i = 0; i < numStops; i++)
		{
			int numExit = in.nextInt();
			int numEnter = in.nextInt();
			
			currentNumPeople = currentNumPeople - numExit + numEnter;
			if(currentNumPeople > max)
			{
				max = currentNumPeople;
			}
			
		}
		
		System.out.println(max);
		
	}
}
