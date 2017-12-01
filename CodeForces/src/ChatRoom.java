import java.util.Scanner;
public class ChatRoom 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		/*
		String test = "Apples";
		int indexOfC = test.indexOf('c');
		System.out.println(indexOfC);
		*/
		
		String input = in.next();
		if( isHello(input) )
		{
			System.out.println("YES");
		}else
		{
			System.out.println("NO");
		}
		
	}
	
	public static boolean isHello(String inString)
	{
		if(inString.equals("hello"))
		{
			return true;
		}else if(inString.length() <= 5)
		{
			return false;
		}
		int locationH = inString.indexOf('h');
		if(locationH <0)
		{
			return false;
		}
		//System.out.println(inString);
		
		String inShort = inString.substring(locationH);
		int locationE = inShort.indexOf('e');
		if(locationE < 0)
		{
			return false;
		}
		//System.out.println(inShort);
		
		inShort = inShort.substring(locationE);
		int locationL1 = inShort.indexOf('l');
		if(locationL1 < 0 && locationL1 == inShort.length())
		{
			return false;
		}
		
		inShort = inShort.substring(locationL1+1);
		int locationL2 = inShort.indexOf('l');
		if(locationL2 < 0)
		{
			return false;
		}
		
		inShort = inShort.substring(locationL2);
		int locationO = inShort.indexOf('o');
		if(locationO < 0)
		{
			return false;
		}else
		{
			return true;
		}
		
	}
}
