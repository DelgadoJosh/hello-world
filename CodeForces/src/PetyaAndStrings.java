import java.util.*;

public class PetyaAndStrings 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String stringA = in.next();
		String stringB = in.next();
		stringA = stringA.toLowerCase();
		stringB = stringB.toLowerCase();
		
		//System.out.println(stringA.compareTo(stringB));
		int comp = stringA.compareTo(stringB);
		
		if(comp > 0)
		{
			System.out.println("1");
		} else if(comp < 0)
		{
			System.out.println("-1");
		} else if(comp == 0)
		{
			System.out.println("0");
		}
	}
}
