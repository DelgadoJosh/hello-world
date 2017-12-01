import java.util.*;

public class simplicity 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		char[] input = in.next().toCharArray();
		int length = input.length;
		int[] freq = new int[26];
		
		for(int i = 0; i < length; i++)
		{
			freq[ (int)input[i] - 'a']++;
		}
		
		Arrays.sort(freq);;
		int sum = 0;
		for(int i = 0; i < 24; i++)
		{
			sum+= freq[i];
		}
		System.out.println(sum);
	}
}

/*
string
letter
aaaaaa
uncopyrightable
ambidextrously
assesses
assassins 
  
*/
