import java.util.*;

public class Bitpp 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numTests = in.nextInt();
		int output = 0;
		
		//Go through each statement
		for(int i = 0; i < numTests; i++)
		{
			String token = in.next();
			
			if(token.indexOf("+") != -1)
			{
				output++;
			} else 
			{
				output--;
			}
		}
		
		System.out.println(output);
	}
}
