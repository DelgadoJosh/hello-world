import java.util.Scanner;

public class mines 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		//input cube shape
		int width = in.nextInt();
		int[][][] cube = new int[width][width][width];
		for(int row = 0; row < width; row++)
		{
			for(int col = 0; col < width; col++)
			{
				for(int depth = 0; depth < width; depth++)
				{
					cube[row][col][depth] = in.nextInt();
				}
			}
		}
		
		//Inputting test points
		int numTests = in.nextInt();
		int[][] points = new int[numTests][3];
		for( int i = 0; i < numTests; i++)
		{
			int row = in.nextInt();
			int col = in.nextInt();
			int depth = in.nextInt();
			points[i][0] = row;
			points[i][1] = col;
			points[i][2] = depth;
		}
		
		
		//Processing
		for(int i = 0; i < numTests; i++)
		{
			int volume = spread(cube, points[i][0], points[i][1], points[i][2], 0);
			
			System.out.println("Simulation #" + (i+1) + ", volume cleared is " + volume + " cubic feet.");
			System.out.println("");
		}
		
		in.close();
		
	}
	
	
	
	//Recursively counts the amount of connecting blocks
	public static int spread(int[][][] inArray, int startRow, int startCol, int startDepth, int volume)
	{
		//System.out.println("Currently at: " + (startRow) + " " + startCol + " " + startDepth + "  Volume: " + volume);
		if(inArray[startRow][startCol][startDepth] == 0)
		{
			//System.out.println("Stopping.");
			return 0;
		} else 
		{
			volume++;
			inArray[startRow][startCol][startDepth] = 0;
		}
		
		//Checks if above layer has rock
		if(startRow > 0 && inArray[startRow-1][startCol][startDepth] == 1)
		{
			//System.out.println("Checking above");
			//volume++;
			//inArray[startRow][startCol][startDepth] = 0;
			volume = spread(inArray, startRow-1, startCol, startDepth, volume);
		}
		
		//Checks if up (top view) has rock
		if(startCol < inArray[0].length-1 && inArray[startRow][startCol+1][startDepth] == 1)
		{
			//System.out.println("Checking up");
			//volume++;
			//inArray[startRow][startCol][startDepth] = 0;
			volume = spread(inArray, startRow, startCol+1, startDepth, volume);
		}
		
		//Checks if below layer has rock
		if(startRow < inArray.length-1 && inArray[startRow+1][startCol][startDepth] == 1)
		{
			//System.out.println("Checking below");
			//volume++;
			//inArray[startRow][startCol][startDepth] = 0;
			volume = spread(inArray, startRow+1, startCol, startDepth, volume);
		}
		
		//Checks if down (top view) has rock
		if(startCol > 0 && inArray[startRow][startCol-1][startDepth] == 1)
		{
			//System.out.println("Checking down");
			//volume++;
			//inArray[startRow][startCol][startDepth] = 0;
			volume = spread(inArray, startRow, startCol-1, startDepth, volume);
		}
		
		//Checks if right (top view) has rock
		if(startDepth < inArray[0][0].length-1 && inArray[startRow][startCol][startDepth+1] == 1)
		{
			//System.out.println("Checking right");
			//volume++;
			//inArray[startRow][startCol][startDepth] = 0;
			volume = spread(inArray, startRow, startCol, startDepth+1, volume);
		}
		
		//Checks if left (top view) has rock
		if(startDepth > 0 && inArray[startRow][startCol][startDepth-1] == 1)
		{
			//System.out.println("Checking left");
			//volume++;
			//inArray[startRow][startCol][startDepth] = 0;
			volume = spread(inArray, startRow, startCol, startDepth-1, volume);
		}
		
		
		//Checks if all around are 0; Will double count everyone... Never mind, same problem.
		/*
		if(    !(  (startRow > 0 && inArray[startRow-1][startCol][startDepth] == 1) 
				|| (startCol < inArray[0].length-1 && inArray[startRow][startCol+1][startDepth] == 1)
				|| (startRow < inArray.length-1 && inArray[startRow+1][startCol][startDepth] == 1)
				|| (startCol > 0 && inArray[startRow][startCol-1][startDepth] == 1)
				|| (startDepth < inArray[0][0].length-1 && inArray[startRow][startCol][startDepth+1] == 1)
				|| (startDepth > 0 && inArray[startRow][startCol][startDepth-1] == 1) ) )
		{
			volume++;
			inArray[startRow][startCol][startDepth] = 0;
		}
		*/
		
		return volume;
	}
}
