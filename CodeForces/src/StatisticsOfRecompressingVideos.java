//J Delgado
// 11/17/17
// Start: 10:26PM

import java.util.*;
import java.lang.*;

public class StatisticsOfRecompressingVideos 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numVideos = in.nextInt();
		int numServers = in.nextInt();
		
		PriorityQueue<Long> servers = new PriorityQueue<Long>();
		
		for(int i = 0; i < numServers; i++)
		{
			servers.offer((long)0);
		}
		
		//Reads through every video
		for(int i = 0; i < numVideos; i++)
		{
			int startTime = in.nextInt();
			int duration = in.nextInt();
			
			long whenReady = servers.poll();
			long nextReady = Math.max(startTime, whenReady) + duration;
			
			servers.offer(nextReady);
			System.out.println(nextReady);
			
		}
	}
}

/*
3 2
1 5
2 5
3 5


6 1
1 1000000000
2 1000000000
3 1000000000
4 1000000000
5 1000000000
6 3

*/