import java.util.*;

public class CapsLock 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String input = in.next();
		
		String onlyUpperCase = input.toUpperCase();
		String case2 = input.substring(0, 1).toLowerCase() + input.substring(1).toUpperCase();
		
		String changed = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
		
		if( input.equals(case2) )
		{
			System.out.println(changed);
		} else if (input.equals(onlyUpperCase))
		{
			System.out.println( input.toLowerCase() );
		} else
		{
			System.out.println(input);
		}
	}
}

//Can be further simplified if only checks if letters after first are capitalized; the first letter doesn't matter.
// Nevermind, misread question
// My error was thinking the output was always the first Cap, then all lowercase.
// But no, it wants it switched
