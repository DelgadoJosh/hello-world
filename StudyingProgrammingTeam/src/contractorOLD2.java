import java.util.*;
/*
public class contractor 
{
	public final long maxPay = 0;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		//Goes through each test case
		int numCases = in.nextInt();
		for(int i = 0; i < numCases; i++)
		{
			
			ArrayList<job> jobs = new ArrayList<job>();
			int numJobs = in.nextInt();
			int numWorkDays = in.nextInt();
			
			//Puts input into jobs arrayList
			for(int j = 0; j < numJobs; j++)
			{
				int days = in.nextInt();
				int pay = in.nextInt();
				jobs.add( new job(days, pay) );
			}
			//Collections.sort(jobs); //Sorts into descending order based on most efficient job.
			
			//System.out.println(jobs); //Debugging
			
			//ArrayList<job> temp = new ArrayList<job>();
			//long max = findMaxJobs(jobs, temp, numWorkDays, (long)0, 0);
			
			long max = findMaxJobs(jobs, numWorkDays, 0, 0, 0);
			
			System.out.println(max);
		}
	}
	
	//Recursive/backtracking function to find the maximum pay
	//Should initialize with currentMax = 0, currentIndex = 0;
	public static long findMaxJobs(ArrayList<job> jobs, ArrayList<job> currentJobs, int maxDays, long currentMax, int currentIndex)
	{
		//Base case, if the days are greater than 
		if( getNumDays(currentJobs) > maxDays)
		{
			//System.out.println("Check: Found base case with currentJobs: " + currentJobs);
			int indexEnd = currentJobs.size()-1;
			job temp = currentJobs.get(indexEnd);
			currentJobs.remove( indexEnd); //This takes too long.
			long currentPay = getPay(currentJobs);
			//System.out.println("CurrentPay = " + currentPay);
			currentJobs.add(temp);
			return currentPay;
		}
		if( currentIndex == jobs.size())
		{
			//System.out.println("Check: Found base case after running out of things to add with currentJobs: " + currentJobs);
			currentMax = Math.max(currentMax, getPay(currentJobs));
			return currentMax;
		}
		
		//Should run for all arrays containing this current value
		//System.out.println("Adding jobs.get(" + currentIndex + "): " + jobs.get(currentIndex));
		currentJobs.add( jobs.get(currentIndex) );
		currentMax = Math.max(currentMax,  findMaxJobs(jobs, currentJobs, maxDays, currentMax, currentIndex+1) );
		//System.out.println("Current max: " + currentMax + " with currentJobs " + currentJobs + " at currentIndex " + currentIndex);
			
		//Should run for all arrays not containing this value
		//System.out.println("Removing CurrentJob " + (currentJobs.size() -1) + ": " + currentJobs.get(currentJobs.size() -1 ));
		currentJobs.remove( currentJobs.size() -1 ); //wait... arraylists are pointers now???
		currentMax = Math.max(currentMax,  findMaxJobs(jobs, currentJobs, maxDays, currentMax, currentIndex+1) );
		//System.out.println("Current max: " + currentMax + " with currentJobs " + currentJobs + " after removal");
		
		return currentMax;
	}
	
	// This attempts recursion, but without editing the lists in order to speed up the time.
	// Just keep track of total days and total money!
	public static long findMaxJobs(ArrayList<job> jobs, int maxDays, int currentIndex, long currentMoney, int currentDays)
	{
		//EndCase at the end of the Array
		if(currentIndex == jobs.size())
		{
			//System.out.println("Reached end of Array\n");
			return currentMoney;
		}
		
		//Values if add current day's values to the days and money
		int tempDays = currentDays + jobs.get(currentIndex).days;
		long tempMoney = currentMoney + jobs.get(currentIndex).pay;
		
		//Base Case: New Days > maxDays
		if(tempDays > maxDays)
		{
			//System.out.println("Too many days to work\n");
			return currentMoney;
		}
		
		/*
		System.out.println("CurrentIndex = " + currentIndex);
		System.out.println("CurrentDays = " + currentDays);
		System.out.println("CurrentMoney = " + currentMoney);
		System.out.println("TempDays = " + tempDays);
		System.out.println("TempMoney = " + tempMoney);
		System.out.println();*/
		
		/*
		//Adds the current index to the total
		long takeIt=findMaxJobs(jobs, maxDays, currentIndex + 1, tempMoney, tempDays);
		
		//Doesn't add the current Index to the total
		long dontTakeIt = findMaxJobs(jobs, maxDays, currentIndex + 1, currentMoney, currentDays);
		
		
		return Math.max(takeIt, dontTakeIt);
	}
	
	//Returns number of days worked given arrayLIst of jobs.
	public static int getNumDays( ArrayList<job> jobs)
	{
		int sum = 0;
		for(int i = 0; i < jobs.size(); i++)
		{
			sum += jobs.get(i).days;
		}
		return sum;
	}
	
	//Returns the current pay of the jobs selected
	public static long getPay( ArrayList<job> jobs)
	{
		long sum = 0;
		for(int i = 0; i < jobs.size(); i++)
		{
			sum += jobs.get(i).pay;
		}
		return sum;
	}
}


class job3 implements Comparable<job>
{
	public int days;
	public int pay;
	public double payPerDay;
	
	//Basic constructor
	public job(int time, int paid)
	{
		days = time;
		pay = paid;
		payPerDay = 1.0*pay/days;
	}
	
	//Descending order based on the payPerDay of job
	public int compareTo( job other )
	{
		if( this.payPerDay != other.payPerDay)
		{
			if( this.payPerDay > other.payPerDay)
			{
				return -1; //This is negative because want descending order, not ascending
			} else
			{
				return 1;
			}
			//return (int)(this.payPerDay - other.payPerDay); //What if the difference <1?
		} else
		{
			return this.days - other.days; //What if two identical jobs with same pay and same time?
		}
	}
	
	public String toString()
	{
		return "(" + days + ", " + pay + ", " + payPerDay + ")";
	}
}



/*
2
2 5
3 10000
4 8000
3 100
20 20000
40 50000
40 30000

1
2 5
6 500
10 4000

1
2 5
3 0
5 0

1
4 60
45 45
20 19
20 19
20 19

1
1 365
365 10


*/



