import java.util.ArrayList;
import java.util.Scanner;

public class bunnies {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		//Declare variables
		int numTests = in.nextInt();
		//ArrayList<char[][]> mazes = new ArrayList<char[][]>();
		boolean[] output = new boolean[numTests];
		
		//input into arrays
		for(int i = 0; i < numTests; i++)
		{
			int r = in.nextInt();
			int c = in.nextInt();
			char[][] thisArray = new char[r][c];
			//Goes through each row
			for(int j = 0; j < r; j++)
			{
				String rowData = in.next();
				char[] rowChar = rowData.toCharArray();
				thisArray[j] = rowChar;
			}
			
			//printArray(thisArray);
			//mazes.add(thisArray);
			
			//Finds P position
			int[] pPos = findP(thisArray);
			
			//Uses P position to spread P across the map recursively
			char[][] spreadArray = spread(thisArray, pPos[0], pPos[1]);
			printArray(spreadArray); //debugging
			
			//Adds to array if PC meet
			output[i] = doPCMeet(spreadArray);
		}
		
		//output
		for(int i = 0; i < numTests; i++)
		{
			if(output[i])
			{
				System.out.println("yes");
			}
			else
			{
				System.out.println("no");
			}
		}
		
		in.close();
	}
	
	//Assume: startRow & startCol is location of P
	public static char[][] spread(char[][] inArray, int startRow, int startCol)
	{
		//char[][] outArray = new char[inArray.length][ inArray[0].length ];
		char[][] outArray = inArray;
		
		
		//Checks if above is empty
		if(startRow > 0 && inArray[startRow-1][startCol] == '_')
		{
			outArray[startRow-1][startCol] = 'P';
			outArray = spread(outArray, startRow-1, startCol);
		}
		
		//Checks if right is empty
		if(startCol < inArray[0].length-1 && inArray[startRow][startCol+1] == '_')
		{
			outArray[startRow][startCol+1] = 'P';
			outArray = spread(outArray, startRow, startCol+1);
		}
		
		//Checks if bottom is empty
		if(startRow < inArray.length-1 && inArray[startRow+1][startCol] == '_')
		{
			outArray[startRow+1][startCol] = 'P';
			outArray = spread(outArray, startRow+1, startCol);
		}
		
		//Checks if left is empty
		if(startCol > 0 && inArray[startRow][startCol-1] == '_')
		{
			outArray[startRow][startCol-1] = 'P';
			outArray = spread(outArray, startRow, startCol-1);
		}
		
		return outArray;
	}
	
	//For Debugging
	public static void printArray(char[][] inArray)
	{
		for(int row = 0; row < inArray.length; row++)
		{
			for(int col = 0; col < inArray[0].length; col++)
			{
				System.out.print(inArray[row][col]);
			}
			System.out.println("");
		}
	}
	
	//Checks array to check if PC meet, given that P has spread and there is only one C.
	public static boolean doPCMeet(char[][] inArray)
	{
		boolean meet = false; //Whoops, unnecessary
		
		//Searches for C
		for(int row = 0; row < inArray.length; row++)
		{
			for(int col = 0; col < inArray[0].length; col++)
			{
				if(inArray[row][col] == 'C')
				{
					//Checks above
					if(row > 0 && inArray[row-1][col] == 'P')
						return true;
					
					//Checks left
					else if(col > 0 && inArray[row][col-1] == 'P')
						return true;
					
					//Bottom
					else if(row < inArray.length-1 && inArray[row+1][col] == 'P')
						return true;
					
					//Right
					else if(col < inArray[0].length-1 && inArray[row][col+1] == 'P')
						return true;
					
					else
						return false;
				}
			}
		}
		return meet;
	}
	
	public static int[] findP(char[][] inArray)
	{
		for(int row = 0; row < inArray.length; row++)
		{
			for(int col = 0; col < inArray[0].length; col++)
			{
				if(inArray[row][col] == 'P')
				{
					int[] output = new int[2];
					output[0] = row;
					output[1] = col;
					return output;
				}
			}
		}
		int output[] = new int[2];
		output[0] = -1;
		output[1] = -1;
		return output;
	}
}
