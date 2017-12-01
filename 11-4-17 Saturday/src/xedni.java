import java.util.*;
public class xedni
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numWords = in.nextInt();
		String[] words = new String[numWords];
		
		for(int i = 0; i < numWords; i++)
		{
			words[i] = in.next();
			words[i] = new StringBuilder(words[i]).reverse().toString();
		}
		Arrays.sort(words);
		
		for(int i =0;i<numWords;i++)
		{
			System.out.println(words[i]);
		}
	}
	
	
}

/*
3
ALCATRAZ
CARDAMOM
BAKLAVA

3
NATION
APPLE
CONDENSATION
*/
