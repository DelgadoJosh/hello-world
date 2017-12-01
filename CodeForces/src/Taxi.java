import java.util.Scanner;

public class Taxi 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numGroups = in.nextInt();
		int[] groupTypes = new int[4];
		
		for(int i = 0; i < numGroups; i++)
		{
			int nextGroup = in.nextInt();
			groupTypes[nextGroup-1] += 1;
		}
		
		/*// TESTING
		for(int i = 0; i < 4; i++)
		{
			System.out.println(groupTypes[i]);
		}
		*/
		
		int taxisNeeded = 0;
		
		taxisNeeded += groupTypes[3];  //Accounts for groups of 4 people.
		
		if(groupTypes[2] < groupTypes[0]) //If there are more groups of 1 than 3
		{
			taxisNeeded += groupTypes[2]; 
			groupTypes[0] -= groupTypes[2]; //Match every group of 3 with a group of 1;
		} else if(groupTypes[2] >= groupTypes[0]) //If there are more groups of 3 than 1
		{
			taxisNeeded += groupTypes[0];	
			groupTypes[2] -= groupTypes[0];	//Assigned all groups of 1 to the groups of 3
			taxisNeeded += groupTypes[2];
			groupTypes[0] = 0;
		}
		
		taxisNeeded += groupTypes[1]/2; //Combine groups of 2 together
		groupTypes[1] = groupTypes[1]%2;
		
		//At this point, there may be 0/1 group of 2 left, and unknown number of groups of 1 left
		//All groups of 3 and 4 have been assigned. 
		
		if(groupTypes[1] > 0 && groupTypes[0] >= 2)
		{
			taxisNeeded += 1;
			groupTypes[1] = 0;
			groupTypes[0] -= 2;
		} else if(groupTypes[1] > 0 && groupTypes[0] == 1)
		{
			taxisNeeded += 1;
			groupTypes[1] = 0;
			groupTypes[0] -=1;
		} else if(groupTypes[1] > 0) //No groups of 1 left
		{
			taxisNeeded += 1;
			groupTypes[1] = 0;
		}
		
		//Assigns all remaining groups of 1 to a group
		if(groupTypes[0]%4 == 0)
		{
			taxisNeeded += groupTypes[0]/4;
		}else if(groupTypes[0] > 0)
		{
			taxisNeeded += groupTypes[0]/4 +1;
		}
		
		System.out.println(taxisNeeded);
		
	}
}
