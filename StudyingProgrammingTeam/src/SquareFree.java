import java.util.*;

public class SquareFree 
{
	public static int MAX = 1000000;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		//Creates an array to store if the index is a square
		// 1 = isSqure, 0 = is not
		int[] isSquare = new int[MAX+1];
		
		//Goes through and finds all squares
		for(int i = 1; i < Math.sqrt(MAX)+1; i++)
		{
			int square = i*i;
			isSquare[square] = 1;
		}
		
		//Array that stores number of squares before it
		int numSquares[] = new int[MAX+1];
		numSquares[0] = 0;
		for(int i = 1; i < MAX+1; i++)
		{
			numSquares[i] = numSquares[i-1] + isSquare[i];
		}
		
		
		
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			
			//Debugging
			//System.out.print("a: " + a + " b: " + b + " " + "numSquares[a] = " + numSquares[a] + " numSquares[b] = " + numSquares[b] + " ");
			
			//Assumes all numbers between them are non-squares(b-a), 
			//then subtracts squares (numSquares[b] - numSquares[a]).
			int numNonSquares = (b-(a-1)) - (numSquares[b] - numSquares[a-1]); 
			
			System.out.println(numNonSquares);
			
		}
		
		
		
	}
}
