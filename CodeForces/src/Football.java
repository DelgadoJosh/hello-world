import java.util.*;

public class Football 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String input = in.next();
		boolean notDone = true;
		
		while(notDone)
		{
			//Begins with 0
			if(input.indexOf("0") == 0)
			{
				int posOne = input.indexOf("1");
				//System.out.println("posOne = " + posOne);
				
				//There are at least 7 zeroes in order
				if(posOne >= 7)
				{
					System.out.println("YES");
					break;
				}
				
				//Whatever remains is just 0's, and there are less than 6
				if(posOne == -1) 
				{
					if(input.length() >= 7)
					{
						System.out.println("YES");
						break;
					}
					System.out.println("NO");
					break;
				}
				
				//Repeat with just the remainder of the string
				input = input.substring(posOne);
				//System.out.println(input);
			} 
			
			//Begins with 1
			else if(input.indexOf("1") == 0)
			{
				int posZero = input.indexOf("0");
				//System.out.println("posZero = " + posZero);
				
				//There are at least 7 ones in order
				if(posZero >= 7)
				{
					System.out.println("YES");
					break;
				}
				
				//Whatever remains is just 1's, and there are less than 6
				if(posZero == -1) 
				{
					if(input.length() >= 7)
					{
						System.out.println("YES");
						break;
					}
					System.out.println("NO");
					break;
				}
				
				//Repeat with just the remainder of the string
				input = input.substring(posZero);
			} else
			{
				System.out.println("Error");
				notDone = false;
				break;
			}
			
			//notDone = false;
			
		}
	}
}
