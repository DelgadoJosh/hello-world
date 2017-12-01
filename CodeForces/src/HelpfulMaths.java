import java.util.*;

public class HelpfulMaths 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		String input = in.next();
		String output = "";
		
		//Convert to just numbers
		for(int i = 0; i < input.length()-1; i+=2)
		{
			output = output + input.substring(i, i+1);
		}
		output = output + input.substring( input.length()-1);
		
		//Feel kinda stupid for thinking of this AFTER I type the above code
		//output = input.replaceAll("[+]", "");
		
		//System.out.println(output);
		
		
		char[] charArray = output.toCharArray();
		Arrays.sort(charArray);
		//System.out.println(charArray);
		
		String output2 = "";
		
		//Generate string of 1+1+2+2+... until 3+ (missing last number)
		for(int i = 0; i < charArray.length - 1; i++)
		{
			output2 = output2 + charArray[i] + "+";
		}
		
		//Attach last number
		output2 = output2 + charArray[charArray.length-1];
		
		System.out.println(output2);
	}
}
