import java.util.*;

public class preComp 
{
	static StringBuilder output;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++) //Derp, forgot for loop -_-
		{
			int end = in.nextInt();
			if(end <= 0)
			{
				break;
			}
			for(int j = 1; j < 10; j++)
			{
				go(j, 2, end);
			}
		}
	}
	
	public static void go(int currentNum, int index, int end)
	{
		//Base Case: at end
		if(index == end+1)
		{
			//Here: Do whatever with the num. Here I'm printing it out
			System.out.println(currentNum); //Could add to stringBuilder if Too long
			return;
		}
		
		for(int i = 0; i < 10; i++)
		{
			int temp = currentNum*10 + i;
			if(temp % index == 0)
			{
				go(temp, index+1, end);
			}
		}
	}
	
}


/*
1
1

1
2

*/
