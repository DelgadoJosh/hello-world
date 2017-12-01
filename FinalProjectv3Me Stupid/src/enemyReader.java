// ***NOTE: Make sure you update the FILE_LOC ***
//
// This file reads in the enemy wave information from a text file
// To use this, first use enemyReader.initialize();
// Then to access the waveEnemyType, do enemyReader.waveEnemyType
// Then to access the waveDelay, do enemyReader.waveDelay

import java.io.*;
import java.util.*;

public class enemyReader 
{
	public static String FILE_LOC = "src\\enemyTest.txt"; // File Location
	public static ArrayList<String[]> waveEnemyType;
	public static ArrayList<int[]> waveDelay;
	public static ArrayList<int[]> waveLocation;
	public static ArrayList<Enemy[]> waveEnemies;
	public static int wFrame;
	public static int hFrame;
	
	//This is for testing.
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		initialize();
		System.out.println("Successfully Initialized");
		
		printInfo();
	}
	
	//Reads in the enemy wave information from a text file, 
	//and stores it in the waveEnemyType, waveDelay, and waveLocation ArrayLists
	public static void initialize() throws IOException
	{
		//Creates Buffered Reader to read textFile
		//Remember to change the file Input location
		BufferedReader fin = new BufferedReader( new FileReader(FILE_LOC) );
		
		//Reads in number of waves
		int numWaves = Integer.parseInt(fin.readLine() );
		
		//Initialize ArrayLists
		waveEnemyType = new ArrayList<String[]>();
		waveDelay = new ArrayList<int[]>();
		waveLocation = new ArrayList<int[]>();
		waveEnemies = new ArrayList<Enemy[]>();
		
		//Reads in each wave of enemies
		for(int i = 0; i < numWaves; i++)
		{
			//Reads in number of Enemies
			int numEnemies = Integer.parseInt(fin.readLine() );
			
			String[] enemyTypes = new String[numEnemies];
			int[] delay = new int[numEnemies];
			int[] location = new int[numEnemies];
			Enemy[] enemies = new Enemy[numEnemies];
						
			//Reads in each enemyType
			for(int j = 0; j < numEnemies; j++)
			{
				//Reads in a line, and breaks it apart into tokens into a String Array sArray
				String line = fin.readLine();
				String[] sArray = line.split(" ");
				//print(sArray);
				
				//If user inputs a new type of enemy with overriden health, speed, and score
				//(For boss creation)
				//
				//Syntax:   new enemyTYPE health speed score delay xSpawn
				//
				//The enemyType is so you could have the specific behaviors of special enemies if wished
				//Optional: Could do it so you don't need a "new" keyword, and it will merely take it in based on length
				//Optional: Add boss label, which includes it in the type, and will thus label the enemy as special
				//Note: If xSpawn is Out of Bounds, it will spawn randomly.
				//Note: Currently, delay is in sec/100
				if(sArray[0].equals("new") )
				{
					String temp = "";
					//Reads in "new enemyTYPE health speed score " as Temp
					for(int k = 0; k < 5; k++)
					{
						temp += sArray[k] + " ";
					}
					enemyTypes[j] = temp;
					delay[j] = Integer.parseInt(sArray[sArray.length-2]);
					location[j] = Integer.parseInt(sArray[sArray.length-1]);
				}
				
				//For default user input
				//Syntax: enemyType delay xSPawn
				//Note: if xSpawn is Out of Bounds, it will spawn randomly.
				else
				{
					enemyTypes[j] = sArray[0];
					delay[j] = Integer.parseInt(sArray[sArray.length-2]);
					location[j] = Integer.parseInt(sArray[sArray.length-1]);
				}
				
				enemies[j] = createEnemy(i, j, enemyTypes[j]);
				
			}
			
			waveEnemyType.add(enemyTypes);
			waveDelay.add(delay);
			waveLocation.add(location);
			waveEnemies.add(enemies);
			
		}
				
		//Closes reader
		fin.close();
				
	}
	
	public static Enemy createEnemy(int wave, int enemyNum, String enemyType)
	{
		String[] sArray = enemyType.split(" ");
		String id = wave + "-" + enemyNum;
		
		//If it is a custom enemy
		if(sArray.length > 1)
		{
			int health = Integer.parseInt(sArray[2]);
			int spd = Integer.parseInt(sArray[3]);
			return new Enemy(id, health, spd, wFrame, hFrame);
		}
		
		//If it is a prebuilt case
		else
		{
			//Returns the enemy based on prefabricated settings
			switch(enemyType)
			{
			case "TypeA" :
				return new Enemy(id, 1, 1, wFrame, hFrame);
			case "TypeB" :
				return new Enemy(id, 2, 1, wFrame, hFrame);
			case "A" :
				return new Enemy(id, 1, 1, wFrame, hFrame);
			case "B" :
				return new Enemy(id, 2, 1, wFrame, hFrame);
			case "C" :
				return new Enemy(id, 3, 1, wFrame, hFrame);
			case "D" :
				return new Enemy(id, 4, 1, wFrame, hFrame);
			default : 
				return new Enemy(id, 1, 1, wFrame, hFrame);
			}
		}
		
	}
	
	//Prints out String Arrays
	public static void print(String[] input)
	{
		String output = "[";
		for(int i = 0; i < input.length; i++)
		{
			output += input[i] + " ";
		}
		output = output.substring(0, output.length()-1) + "]";
		System.out.println(output);
	}
	
	//Prints out Integer Arrays
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
	
	//Prints out information about the enemyTypes
	public static void printInfo()
	{
		for(int i = 0; i < waveEnemyType.size(); i++)
		{
			System.out.println("Enemies in wave " + (i+1) + ": " );
			for(int j = 0; j < waveEnemies.get(i).length; j++)
			{
				System.out.println(waveEnemies.get(i)[j]);
			}
			System.out.print( "Enemy Types in Wave " + (i+1) + ": " ); //+ waveEnemyType.get(i) );
			print(waveEnemyType.get(i));
			System.out.print( "Delay in Wave " + (i+1) + ": "); // + waveDelay.get(i) );
			print(waveDelay.get(i));
			System.out.print( "Location in Wave " + (i+1) + ": "); // + waveDelay.get(i) );
			print(waveLocation.get(i));
		}
	}
}
