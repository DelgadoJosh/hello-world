import java.util.*;
import java.io.*;

public class PersonalDictonaryMk2 
{
	public static void main(String[] args) throws IOException
	{
		String token = "";
		BufferedReader inFile = new BufferedReader(new FileReader("C:\\Users\\detja\\Desktop\\Josh's Folder\\Programming\\Eclipse\\PersonalProjects\\src\\words.txt") );
		//Scanner inFile = new Scanner(fileName);
		
		BufferedWriter outFile = new BufferedWriter( new FileWriter("C:\\Users\\detja\\Desktop\\Josh's Folder\\Programming\\Eclipse\\PersonalProjects\\src\\leftHand.txt") );
		
		//for(int i = 0; i < 100000; i++)
		while( (token=inFile.readLine()) != null)
		{
			token = token.toLowerCase();
			String tokenNoRight = token.replaceAll("[yuiophjklnm]","");
			if(token.equals( tokenNoRight ) )
			{
				outFile.write(token);
				outFile.newLine();
				System.out.println(token);
			}
		}
		
	}
}
