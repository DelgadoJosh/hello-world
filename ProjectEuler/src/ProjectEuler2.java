

public class ProjectEuler2 
{
	
	public static void main(String[] args)
	{
		int total = 0;
		int currentFib = 0;
		int index = 1;
		while(currentFib < 4000000)
		{
			currentFib = fib(index);
			if(currentFib%2 == 0)
			{
				total+=currentFib;
				//System.out.println(currentFib); //debugging
				//System.out.print("X:"); //debugging
			}
			//System.out.println(currentFib); //debugging
			index++;
		}
		System.out.println("The sum of all the even numbers "
				         + "in the fibonacci sequence under 4 million is: " + total);
	}
	
	public static int fib(int input) //input 1 = 0, input 2 = 1
	{
		if(input == 2)
		{
			return 1;
		}else if(input == 1)
		{
			return 0;
		}else if(input <= 0)
		{
			System.out.println("Input is <= 0");
			return 0;
		}
		return fib(input-1) + fib(input-2);
	}
}
