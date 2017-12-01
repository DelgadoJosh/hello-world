// J Delgado
// 8:06 starting time
// 11/3/17
// 8:17 ending time for solving sample

import java.util.*;


public class tacobell 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++)
		{
			int numFoods = in.nextInt();
			int sizeWanted = in.nextInt();
			String[] foods = new String[numFoods];
			
			for(int j = 0; j < numFoods; j++)
			{
				foods[j] = in.next();
			}
			Arrays.sort(foods);
			
			printCombinations(foods, sizeWanted);
			System.out.println();
		}
		
	}
	
	//Prints using the binary as a way for finding all combinations
	//However, does not print in the correct order...
	public static void printCombinations( String[] array, int sizeWanted)
	{
		int size = array.length;
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		ArrayList<String> output2 = new ArrayList<>();
		
		for(int i = 0; i < (1 << size); i++)
		{
			ArrayList<String> subset = new ArrayList<String>();
			String subset2 = "";
			for(int j = 0; j < size; j++)
			{
				if( (i&(1<<j)) != 0)
				{
					subset.add(array[j]);
					//subset2 += " " + array[j];
					subset2 += array[j] + " ";
				}
			}
			Collections.sort(subset); //Redundant, but whatev
			if(subset.size() == sizeWanted)
			{
				output.add(subset);
				//output2.add(subset2.substring(1)); //Substring to get rid of leading space.
				output2.add(subset2);
			}
		}
		
		Collections.sort(output2);
		
		for(int i = 0; i< output.size(); i++)
		{
			
			for(int j = 0; j < sizeWanted; j++)
			{
				//System.out.print(output.get(i).get(j) + " ");
			}
			System.out.print(output2.get(i));
			System.out.println();
		}
		
	}

	//Was going to attempt the other way of creating the
	// combinations in order, but then I thought of the string
	// solution. Woah, that was easier. Still, should try to code it this way
	// Just in case.
	public static void printCombinations( String[] array, int sizeWanted, int dud)
	{
		
	}
}

/*
2
3 2
taco
burrito
nachos
4 4
chalupa
softshelltaco
gordita
pizza

2
3 0
taco
burrito
nachos
4 4
chalupa
softshelltaco
gordita
pizza


*/