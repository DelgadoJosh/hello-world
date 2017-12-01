import java.util.*;

public class WordCapitalization 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String input = in.next();
		String firstL = input.substring(0,1);
		
		firstL = firstL.toUpperCase();
		String output = firstL + input.substring(1);
		
		System.out.println(output);
	}
}
