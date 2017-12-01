import java.util.*;

public class StringTask 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String input = in.next();
		
		input = input.toLowerCase();
		input = input.replaceAll("[aeiouy]", "");
		
		for(int i = 0; i<input.length(); i+=2)
		{
			input = input.substring(0, i) + "." + input.substring(i);
		}
		
		System.out.println(input);
	}
}
