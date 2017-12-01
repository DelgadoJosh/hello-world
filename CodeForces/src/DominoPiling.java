import java.util.Scanner;

public class DominoPiling 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int m = in.nextInt();
		int n = in.nextInt();
		//Derp -_- No need for ifthen statement
		
		int total = (m*n)/2;
		System.out.println(total);
		
		/*
		if(m%2 != 0 && n%2 != 0)
		{
			int total = (m*n)/2;
			System.out.println(total);
		}else
		{
			int total = (m*n)/2;
			System.out.println(total);
		}
		*/
	}
}
