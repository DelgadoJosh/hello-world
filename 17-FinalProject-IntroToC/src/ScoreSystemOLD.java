import java.util.*;
import java.io.*;

//Thanks, this website!
//https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
//https://stackoverflow.com/questions/275711/add-leading-zeroes-to-number-in-java //Leading Zeroes
//https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
/*
public class ScoreSystem 
{
	public static String FILE = "src\\test.txt";
	
	//This is me testing. Don't run this in the main file, run the .recordScore( int score ) method in the main file.
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		System.out.println("This is for testing purposes. Please enter your score:");
		int score = in.nextInt();
		recordScore(score);
		
		/*
		//Creates a buffered reader for reading in the score
		BufferedReader fin = new BufferedReader( new FileReader(
				//"C:\\Users\\detja\\Desktop\\Josh's Folder\\Programming\\Eclipse\\17-FinalProject-IntroToC\\src\\test.txt") );
				"src\\test.txt") ); //Should be relative now, and work for most computers
				
		ArrayList<Score> scores = new ArrayList<>();
		
		//Skips 3 lines for the Title and legend
		for(int i = 0; i < 3; i++)
		{
			String dud = fin.readLine();
			//System.out.println(dud);
		}
		
		
		String line;
		while( (line = fin.readLine()) != null) //Can be a forLoop of top10
		{
			String[] sArray = line.split(" ");
			//System.out.println("sArray.length = " + sArray.length);
			int length = sArray.length;
			
			//Since the leading spaces differ,
			//Have to line up the indexes with the end
			int place = Integer.parseInt(sArray[length-1 -2]);
			String name = sArray[length-1 -1];
			int score = Integer.parseInt(sArray[length-1]);
			
			Score tempScore = new Score(score, name);
			scores.add(tempScore);
			
			
			
			
			for(int i = 0; i < sArray.length; i++)
			{
				//System.out.println(sArray[i]);
			}
			//System.out.println(line);
		}
		
		fin.close();
		
		Score[] testData = new Score[4];
		testData[0] = new Score(500, "APP");
		testData[1] = new Score(250, "TST");
		testData[2] = new Score(250, "BOB");
		testData[3] = new Score(99999, "HAX");
		
		for( int i = 0; i < testData.length; i++)
		{
			scores.add(testData[i]);
		}
		
		Collections.sort(scores);
		
		//BufferedWriter fout = new BufferedWriter(new FileWriter("C:\\Users\\detja\\Desktop\\Josh's Folder\\Programming\\Eclipse\\17-FinalProject-IntroToC\\src\\testO.txt"));
		
		
		//File Output. For actual thing, make sure to change the file so it goes to same location
		PrintWriter fout = new PrintWriter(
				//"C:\\Users\\detja\\Desktop\\Josh's Folder\\Programming\\Eclipse\\17-FinalProject-IntroToC\\src\\testO.txt");
				"src\\testO.txt");
				
		fout.println(" SCOREBOARD  ");
		fout.println("=============");
		fout.println("RNK|PLR|SCORE");
		
		//fout.write("Test\n");
		
		for(int i = 0; i < scores.size(); i++)
		{
			fout.printf("%3d %3s %05d", (i+1), scores.get(i).playerName, scores.get(i).score);
			fout.println();
		}
		
		fout.close(); *//*
	}
	
	//PreCondition: 5-digit integer score
	// Will prompt user for their 3 Letter Initials. 
	// If longer or shorter than 3 letters, will ask again.
	// Then it will read the currentScore
	// Add their score, and sort it
	// Then output the top 10 to the file
	public static void recordScore(int score) throws IOException
	{
		//Reads in top 10 scores and stores in an ArrayList
		ArrayList<Score> scores = readScore();
		
		//Asks for name of player
		String name = askName();
		
		//Adds in player score and sorts
		scores.add( new Score(score, name) );
		Collections.sort(scores);
		
		//printScores(scores);
		
	}
	
	//Will read in the scores from a text file
	//Then return a sorted ArrayList of the scores.
	public static ArrayList<Score> readScore() throws IOException
	{
		//Creates a buffered reader for reading in the score
		BufferedReader fin = new BufferedReader( new FileReader("src\\test.txt") ); //Should be relative now, and work for most computers
		
		ArrayList<Score> scores = new ArrayList<>();
		
		//Skips 3 lines for the Title and legend
		for(int i = 0; i < 3; i++)
		{
			String dud = fin.readLine();
		}
		
		
		String line;
		//Reads in the top 10 previous scores, and inputs into an arrayList
		while( (line = fin.readLine()) != null) //Can be a forLoop of top10
		{
			String[] sArray = line.split(" ");
			int length = sArray.length;
			
			//Since the leading spaces differ,
			//Have to line up the indexes with the end
			int place = Integer.parseInt(sArray[length-1 -2]);
			String name = sArray[length-1 -1];
			int score = Integer.parseInt(sArray[length-1]);
			
			Score tempScore = new Score(score, name);
			scores.add(tempScore);
			
		}
		
		fin.close();
		
		return scores;
	}
	
	//Asks for 3 Digit Initials of player
	// If not 3 digits, then will ask again
	public static String askName()
	{
		Scanner in = new Scanner(System.in);
		String input = "";
		while(true)
		{
			System.out.println("Please enter your 3 Digit Initials: ");
			input = in.next();
			if(input.length() == 3)
				break;
			else
			{
				System.out.println("Sorry, that is not 3 letters. Please try again");
				System.out.println();
			}
		}
		return input.toUpperCase();
	}
	
	// Prints top 10 scores to a text file
	// Assumes the input ArrayList is at least length 10
	public static void printScores(ArrayList<Score> scores) throws IOException
	{
		PrintWriter fout = new PrintWriter("src\\testO.txt"); //Relative textFile
				
		fout.println(" SCOREBOARD  ");
		fout.println("=============");
		fout.println("RNK|PLR|SCORE");
		
		for(int i = 0; i < scores.size(); i++)
		{
			fout.printf("%3d %3s %05d", (i+1), scores.get(i).playerName, scores.get(i).score);
			fout.println();
		}
		
		fout.close();
	}
	
}

class Score implements Comparable<Score>
{
	public int score;
	public String playerName; //Three Initials
	
	Score( int score, String playerName)
	{
		this.score = score;
		this.playerName = playerName;
	}
	
	public int compareTo( Score other )
	{
		//if(this.score == other.score)
			//return this.playerName.compareTo(other.playerName); //Removed this because I'd rather have whoever scored first to be higher in rank.
		return other.score - this.score; //Oops, reversed it becaues I'm stupid. Derp -_- //this.score - other.score;
	}
	
}*/

