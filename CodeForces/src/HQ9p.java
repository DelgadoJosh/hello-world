import java.util.*;

public class HQ9p 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		//Checking for ASCII Values
		/*
		System.out.println("H = " + (int)'H'); //72
		System.out.println("Q = " + (int)'Q'); //81
		System.out.println("9 = " + (int)'9'); //57
		System.out.println("+ = " + (int)'+'); //43	
		*/
		
		String input = in.next();
		
		char[] cArray = input.toCharArray();
		boolean hasCode = false;
		
		for(int i = 0; i < cArray.length; i++)
		{
			if( (int)cArray[i] == 72 || (int)cArray[i] == 81 || (int)cArray[i] == 57)
			{
				hasCode = true;
				break;
			}
		}
		
		if(hasCode)
		{
			System.out.println("YES");
		} else
		{
			System.out.println("NO");
		}
		
	}
}


// Read more carefully, ya dummie.
// + doesn't make any thing appear on screen. Ya doof.