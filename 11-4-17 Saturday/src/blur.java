import java.util.*;

public class blur 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int width = in.nextInt();
		int height = in.nextInt();
		int blurNum = in.nextInt();
		
		long[][] grid = new long[height][width];
		
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				grid[i][j] = in.nextInt();
			}
		}
		
		for(int i = 0; i < blurNum; i++)
		{
			grid = blur(grid);
		}
		
		//long output = countDistinctNums(grid, blurNum);
		long output = countDistinctNums(grid);
		
		System.out.println(output);
	}
	
	public static long[][] blur(long[][] input)
	{
		int height = input.length;
		int width = input[0].length;
		long[][] output = new long[height][width];
		//Arrays.fill(output, 0);
		
		int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
		
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				for(int k = 0; k < 9; k++)
				{
					output[i][j] += input[ (i + height + dx[k])%height ][ (j + width + dy[k])%width ];
				}
			}
		}
		//printArray(output);
		return output;
	}
	
	// Would store the values in a frequency array. But the array would be too short (limit of integer)
	public static long countDistinctNums(long[][] input, int power)
	{
		int height = input.length;
		int width = input[0].length;
		long[] freq = new long[ (int)(Math.pow(9, power)) ]; //This would glitch out when the length of array > limit of integer
		
		if(power == 0)
		{
			freq = new long[2];
		}
		//Arrays.fill(freq, 0);
		long output = 0;
		
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				freq[ (int)(input[i][j]) ]++;
			}
		}
		
		
		for(int i = 0; i < freq.length; i++)
		{
			if( freq[i] > 0)
			{
				output++;
			}
		}
		
		return output;
	}
	
	// Uses hash map, should allow for easier implementation
	public static long countDistinctNums(long[][] input)
	{
		int height = input.length;
		int width = input[0].length;
		int output = 0;
		
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				map.put( (input[i][j]), (1));
			}
		}
		
		output = map.size();
		
		return output;
	}
	
	public static void printArray( long[][] input)
	{
		for(int i = 0; i < input.length; i++)
		{
			for(int j = 0; j < input[0].length; j++)
			{
				System.out.print(input[i][j]);
			}
			System.out.println();
			
		}
		System.out.println();
	}
}


/*
5 4 1
0 0 1 1 0
0 0 1 1 0
0 0 1 1 0
0 0 1 1 0

3 3 2
1 0 0
0 1 0
0 1 0

3 3 0
1 0 0
0 1 0
0 1 0

 */

