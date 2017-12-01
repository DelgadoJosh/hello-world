import java.util.*;

public class BeautifulMatrix 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int[][] input = new int[5][5];
		int x = 0, y = 0;
		
		for(int row = 0; row < 5; row++)
		{
			for(int col = 0; col < 5; col++)
			{
				input[row][col] = in.nextInt();
				if (input[row][col] == 1)
				{
					x = row;
					y = col;
				}
			}
		}
		
		int output = 0;
		output = Math.abs(x-2) + Math.abs(y-2);
		
		System.out.println(output);
		
	}
}
