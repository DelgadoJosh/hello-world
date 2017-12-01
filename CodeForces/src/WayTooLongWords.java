import java.util.Scanner;

public class WayTooLongWords 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numTests = in.nextInt();
		String[] output = new String[numTests];
		
		for(int i = 0; i < numTests; i++)
		{
			String input = in.next();
			String shortenedWord = shorten(input);
			output[i] = shortenedWord;
		}
		for(int i = 0; i < numTests; i++)
		{
			System.out.println(output[i]);
		}
		
	}
	
	public static String shorten(String inString)
	{
		if(inString.length() <= 10)
		{
			return inString;
		}else if(inString.length() > 10)
		{
			String beginning = inString.substring(0, 1);
			String end = inString.substring( inString.length()-1);
			int midLength = inString.length()-2;
			return beginning + midLength + end;
		}else
		{
			return "ERROR";
		}
	}
}
