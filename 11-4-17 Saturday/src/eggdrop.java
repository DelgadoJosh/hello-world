import java.util.*;

public class eggdrop 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numEggs = in.nextInt();
		int numFloors = in.nextInt();
		
		int[] floorsUsed = new int[numEggs];
		String[] status = new String[numEggs];
		
		boolean[] isSafe = new boolean[numFloors];
		boolean[] isBroken = new boolean[numFloors];
		Arrays.fill(isSafe, true);
		Arrays.fill(isBroken, true);
		
		isSafe[numFloors-1] = false;
		isBroken[0] = false;
		isBroken[1] = false;		
		
		int minBreak = 2;
		int maxSafe = numFloors-1;
		
		for(int i = 0; i < numEggs; i++)
		{
			floorsUsed[i] = in.nextInt();
			status[i] = in.next();
			if(status[i].equals("SAFE"))
			{
				if( floorsUsed[i] >= minBreak)
					minBreak = floorsUsed[i]+1;
			}
			
			if(status[i].equals("BROKEN"))
			{
				if( floorsUsed[i] <= maxSafe)
				{
					maxSafe = floorsUsed[i]-1;
				}
			}
		}
		
		System.out.println(minBreak + " " + maxSafe);
		
	}
}

/*
2 10
4 SAFE
7 BROKEN

3 5
2 SAFE
4 SAFE
3 SAFE

4 3
2 BROKEN
2 BROKEN
1 SAFE
3 BROKEN

1 10
4 BROKEN

1 10
4 SAFE

*/
