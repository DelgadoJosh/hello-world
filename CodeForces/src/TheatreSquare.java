import java.util.Scanner;

public class TheatreSquare 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		long n = in.nextInt();
		long m = in.nextInt();
		long a = in.nextInt();
		long col = 0;
		long row = 0;
		long totalSquares = 0;
		
		//int col = n/a + 1; //Exception: if n/a divides equally
		if(n%a == 0)
		{
			col = n/a;
		} else 
		{
			col = n/a +1;
		}
		
		if(m%a == 0)
		{
			row = m/a;
		}else
		{
			row = m/a +1;
		}
		
		totalSquares = row*col; //In case the max goes over
		//System.out.printf("%-1.0f", totalSquares);
		System.out.println(totalSquares);
		
	}
}
