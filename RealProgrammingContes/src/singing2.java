import java.util.Scanner;
import java.lang.Math;

public class singing2 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int numCases;
		numCases = in.nextInt();
		
		
		long[] output = new long[numCases];
		
		//going through each case
		for(int i = 0; i < numCases; i++)
		{
			int tracks, songs;
			tracks = in.nextInt();
			songs = in.nextInt();
			int[] songsWanted = new int[songs];
			long sum = 0;
			
			//input songs wanted in order in an array
			for(int k = 0; k < songs; k++)
			{
				songsWanted[k] = in.nextInt();
			}
			
			//Calculates whether going backwards or forwards is better
			for(int z = 0; z < songs-1; z++)
			{
				int forewards = Math.abs( (songsWanted[z] + 1) - songsWanted[z+1]); //direct to it
				int backwards = Math.abs( (songsWanted[z+1] + tracks) - (songsWanted[z] + 1) ); //loops around
				//System.out.println("forewards: " + forewards);
				//System.out.println("backwards: " + backwards);
				
				if(forewards < backwards)
				{
					sum += forewards;
				} else if(backwards <= forewards)  //DIRK: TINY TYPO > INSTEAD OF <
				{
					sum += backwards;
				} else 
				{
					sum += backwards;
				}
			}
			output[i] = sum;
		}
		
		for(int i = 0; i < numCases; i++)
		{
			//System.out.println(output[i]);
			//System.out.printf("%-1.0f\n", output[i]);
			System.out.println(output[i]);
		}
		in.close();
		
	}
}
