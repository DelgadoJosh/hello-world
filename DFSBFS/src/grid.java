import java.util.*;

public class grid 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numRows = in.nextInt();
		int numCols = in.nextInt();
		
		int[][] map = new int[numRows][numCols];
		int[][] numJumps = new int[numRows][numCols]; //Should I use longs?
		for(int i = 0; i < numRows; i++)
		{
			Arrays.fill(numJumps[i], -1); //2000000000
		}
		
		// Reads in the Character array
		char[][] cMap = new char[numRows][numCols];
		for(int row = 0; row < numRows; row++)
		{
			cMap[row] = in.next().toCharArray();
		}
		
		// Converts cArrays to int Array
		for(int row = 0; row < numRows; row++)
		{
			for(int col = 0; col < numCols; col++)
			{
				map[row][col] = (int)cMap[row][col];
			}
		}
		
		ArrayDeque<Box> toCheck = new ArrayDeque<Box>();
		
	}
	
	//Returns if it's in bounds
	public static boolean inBounds(int row, int col, int numRows, int numCols)
	{
		return (row >= 0) && (col >= 0) && (row< numRows) && (col < numCols);
	}
	
	
}

class Box
{
	
}

/*
2 2
11
11

2 2
22
22

5 4
2120
1203
3113
1120
1110


*/
