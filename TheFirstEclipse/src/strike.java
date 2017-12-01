//J Delgado
//9/29/17
//Calculates the minimal amount of 

import java.util.Scanner;
import java.util.ArrayList;

public class strike 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = -1;
		
		//ArrayList<Integer> output = new ArrayList<Integer>();
		
		while(n != 0)
		{
			//Number of missiles
			n = in.nextInt();
			if(n == 0)
			{
				break;
			}
			
			//Input tower cords
			int t1x = in.nextInt();
			int t1y = in.nextInt();
			int t2x = in.nextInt();
			int t2y = in.nextInt();
			
			//int[] missileX = new int[n];
			//int[] missileY = new int[n];
			
			missile[] missiles = new missile[n];
			
			
			//Input missile cords
			for(int i = 0; i < n; i++)
			{
				int x = in.nextInt();
				int y = in.nextInt();
			}
			
			
		}
		
	}
}

class missile
{
	double x, y;
	
	public missile(double x, double y)
	{
		this.x = x;
		this.y = y;
		
	}
	
	
}


