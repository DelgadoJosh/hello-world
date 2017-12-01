/*
import java.io.*;
import java.util.*;
public class enemyReader 
{
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		//Creates Buffered Reader to read textFile
		//Remember to change the fileInput location
		BufferedReader fin = new BufferedReader( new FileReader(
				//"C:\\Users\\detja\\Desktop\\Josh's Folder\\Programming\\Eclipse\\17-FinalProject-IntroToC\\src\\enemyTest.txt") );
				"src\\enemyTest.txt") );
		int numWaves = Integer.parseInt(fin.readLine() );
		
		//String line = "";
		//while( (line = fin.readLine()) != null) )
		
		ArrayList<String[]> waveEnemyType = new ArrayList<String[]> ();
		ArrayList<int[]> waveDelay = new ArrayList<int[]> ();
		
		//Reads in each wave of enemies
		for(int i = 0; i < numWaves; i++)
		{
			int numEnemies = Integer.parseInt(fin.readLine() );
			
			String[] enemyTypes = new String[numEnemies];
			int[] delay = new int[numEnemies];
			
			//Reads in each enemyType
			for(int j = 0; j < numEnemies; j++)
			{
				//Reads in a line, and breaks it apart into tokens into a String Array sArray
				String line = fin.readLine();
				String[] sArray = line.split(" ");
				
				//If user inputs a new type of enemy with overriden health, speed, and score
				//For boss creation
				//Syntax:   new enemyTYPE health speed score delay
				//The enemyType is so you could have the specific behaviors of special enemies if wished
				//Optionally: Could do it so you don't need a "new" keyword, and it will merely take it in based on length
				//Optional: Add boss label, which includes it in the type, and will thus label the enemy as special
				if(sArray[0].equals("new") )
				{
					String temp = "";
					for(int k = 1; k < 5; k++)
					{
						temp += sArray[k] + " ";
					}
					enemyTypes[j] = temp;
					delay[j] = Integer.parseInt(sArray[4]);
				}
				
				//For default user input
				//Syntax: enemyType delay
				else
				{
					enemyTypes[j] = sArray[0];
					delay[j] = Integer.parseInt(sArray[sArray.length-1]); //Leaves room for declaring new type of enemy this way
				}
				
			}
			
			waveEnemyType.add(enemyTypes);
			waveDelay.add(delay);
			
		}
		
		for(int i = 0; i < numWaves; i++)
		{
			System.out.print( "Enemy Types in Wave " + (i+1) + ": " ); //+ waveEnemyType.get(i) );
			print(waveEnemyType.get(i));
			System.out.print( "Delay in Wave " + (i+1) + ": "); // + waveDelay.get(i) );
			print(waveDelay.get(i));
		}
		
		
		
		//Closes reader
		fin.close();
		
	}
	
	public static void print(String[] input)
	{
		String output = "[";
		for(int i = 0; i < input.length; i++)
		{
			output += input[i] + " ";
		}
		output += "]";
		System.out.println(output);
	}
	
	public static void print(int[] input)
	{
		String output = "[";
		for(int i = 0; i < input.length; i++)
		{
			output += input[i] + " ";
		}
		output += "]";
		System.out.println(output);
	}
}*/
