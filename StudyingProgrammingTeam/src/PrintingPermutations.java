import java.util.*;
public class PrintingPermutations 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		int size = 5;
		//String[] array = {"a","b","c","d","e"};
		String[] array = {"apples", "churros", "bubble gum", "cabbage", "bananas"};
		
		//printCombinations(array);
		
		//printCombinations(array, 3); //Combinations of a certain size
		
		printCombinations(array, 3, 1); //Uses different way of testing

	}
	
	//Prints all combinations
	public static void printCombinations(String[] array)
	{
		int size = array.length;
		
		System.out.println("All subsets:");
		
		//This goes from 0-31, while i is less than 2^size, which is 32. 
		// This is because every binary int from 0 to 2^size is every combination of 0 and 1s.
		for(int i = 0; i < (1 << size); i++)
		{
			System.out.print("{ ");
			
			// This goes through all indexes of the array.
			// If it's a "1" in the binary version of i, then it will print out.
			for(int indexInArray = 0; indexInArray < size; indexInArray++)
			{
				if( (i & (1<<indexInArray)) != 0)
				{
					System.out.print(array[indexInArray] + " "); //Could add this to an array
				}
			}
			System.out.println("}");
		}
		
	}
	
	
	// Prints out all combinations of a specific size.
	public static void printCombinations(String[] array, int sizeWanted)
	{
		int size = array.length;
		
		System.out.println("Subsets of size " + sizeWanted + ": ");
		
		//This is the output arrayList, since I don't know the spefic number. 
		// Pretty sure it's the binomial thing with total over sizeWanted. But whatever.
		ArrayList< ArrayList<String> > output = new ArrayList< ArrayList<String> >();
		for(int i = 0; i < (1 << size); i++)
		{
			
			ArrayList<String> subset = new ArrayList<String>();
			for(int indexInArray = 0; indexInArray < size; indexInArray++)
			{
				if( (i & (1<<indexInArray)) != 0)
				{
					//System.out.print(array[indexInArray] + " ");
					subset.add(array[indexInArray]);
				}
			}
			
			Collections.sort(subset);
			
			if(subset.size() == sizeWanted)
			{
				output.add(subset);
			}
		}
		
		for(int i = 0; i < output.size(); i++)
		{
			System.out.println(output.get(i));
		}
			
		//Can return output instead
	}
	
	
	//Prints all combinations using a different methodology
	public static void printCombinations(String[] array, int sizeWanted, int dud)
	{
		int size = array.length;
		
		System.out.println("Using Different Methodology: ");
		
		ArrayList<int[]> combinations = generateCArray(size, sizeWanted);
		
		/*
		//This goes from 0-31, while i is less than 2^size, which is 32. 
		// This is because every binary int from 0 to 2^size is every combination of 0 and 1s.
		for(int i = 0; i < (1 << size); i++)
		{
			System.out.print("{ ");
			
			// This goes through all indexes of the array.
			// If it's a "1" in the binary version of i, then it will print out.
			for(int indexInArray = 0; indexInArray < size; indexInArray++)
			{
				if( (i & (1<<indexInArray)) != 0)
				{
					System.out.print(array[indexInArray] + " "); //Could add this to an array
				}
			}
			System.out.println("}");
		}*/
		
	}
	
	
	//Generates all {1,0,1,1,0} arrays for the size inputted
	public static ArrayList<int[]> generateCArray(int sizeArray, int sizeSubset)
	{
		ArrayList<int[]> output = new ArrayList<int[]>();
		int[] tempArray = new int[sizeArray];
		
		//Generates all subsets, and should add to the arrayList, but it doesn't because it's not a pointer...
		output = generateSubset(0, output, tempArray, sizeSubset);
		
		for(int i = 0; i < output.size(); i++)
		{
			System.out.println("Index " + i + ": "+ Arrays.toString( output.get(i) ) );
		}
		
		return output;
	}
	
	// Recursive function for generating all arrays. It should add to arrayList, but it doesn't because it's a pointer.
	// So it instead outputs the arrayList to simulate a pointer
	// Ya know what, screw it. 
	// Make output a static variabl and make it a void method
	public static ArrayList<int[]> generateSubset(int currentIndex, ArrayList<int[]> output, int[] currentArray, int sizeWanted)
	{
		//System.out.println( Arrays.toString(currentArray));
		
		//If reached end of array
		if(currentIndex == currentArray.length) //Or could do currentArray.length == sizeWanted //Nope.
		{
			//What I could do to generate sets of a specific length, is add a function
			//To count number of 1's. If it's == to specific length, then
			System.out.println();
			for(int i = 0; i < output.size(); i++)
			{
				System.out.println("Index " + i + ": "+ Arrays.toString( output.get(i) ) );
			}
			
			System.out.println( Arrays.toString(currentArray));
			output.add(currentArray);
			//System.out.println( "Current 0 index of the output: " + Arrays.toString(output.get(0)));
			for(int i = 0; i < output.size(); i++)
			{
				System.out.println("Index " + i + ": "+ Arrays.toString( output.get(i) ) );
			}
			return output; //Why doesn't this work!?
		}
		
		/*
		for(int i = 0; i < output.size(); i++)
		{
			System.out.println(Arrays.toString(output.get(i)));
		}
		System.out.println();
		*/
		
		//System.out.print("1 " );
		currentArray[currentIndex] = 1;
		output = generateSubset(currentIndex+1, output, currentArray, sizeWanted);
		
		currentArray[currentIndex] = 0;
		ArrayList<int[]> tmp = generateSubset(currentIndex+1, output, currentArray, sizeWanted);
		for (int[] arr : tmp)
			output.add(arr);
		return output;
	}

}
