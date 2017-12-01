import java.util.*;
import java.io.*;

public class PersonalDictonary 
{
	public static void main(String[] args) throws IOException
	{
		String token = "";
		File fileName = new File("words_alpha.txt");
		//Scanner inFile = new Scanner(fileName);
		
		PrintWriter outFile = new PrintWriter(new File("leftHand.txt") );
		
		for(int i = 0; i < 100000; i++)
		{
			//token = inFile.next();
			
			outFile.println(token);
		}
		
	}
}
