import java.util.*;

public class StonesOnTheTable 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int numStones = in.nextInt();
		String input = in.next();
		int output = 0;
		boolean notDone = true;
		
		
		while(notDone)
		{
			int indR = input.indexOf("R");
			int indG = input.indexOf("G");
			int indB = input.indexOf("B");
			
			//Debugging
			/*
			System.out.println(output);
			System.out.println("IndR = " + indR);
			System.out.println("IndG = " + indG);
			System.out.println("IndB = " + indB);
			System.out.println();
			*/
			
			
			//Red first letter
			if(indR == 0)
			{
				//If red is the only color remaining
				if(indG == -1 && indB == -1)
				{
					output += input.length()-1;
					break;
				}
				
				//Only green remains
				if(indB == -1 && indG != -1)
				{
					output += indG-1;
					input = input.substring(indG);
					continue;
				}
				
				//Only blue remains
				else if(indG == -1 && indB != -1)
				{
					output += indB-1;
					input = input.substring(indB);
					continue;
				}
				
				//Green is the next color and exists in the string
				else if(indG != -1 && indG < indB)
				{
					output += indG-1;
					input = input.substring(indG);
					continue;
				} 
				
				//Blue is the next color
				else if(indB != -1 && indB < indG)
				{
					output += indB-1;
					input = input.substring(indB);
					continue;
				}
				
			} 
			
			//Green first
			else if(indG == 0)
			{
				//If green is the only color remaining
				if(indR == -1 && indB == -1)
				{
					output += input.length()-1;
					break;
				}
				
				
				//Only red remains
				if(indB == -1 && indR != -1)
				{
					output += indR-1;
					input = input.substring(indR);
					continue;
				}
				
				//Only blue remains
				else if(indR == -1 && indB != -1)
				{
					output += indB-1;
					input = input.substring(indB);
					continue;
				}
				
				//Red is the next color and exists in the string
				else if(indR != -1 && indR < indB)
				{
					output += indR-1;
					input = input.substring(indR);
					continue;
				} 
				
				//Blue is the next color
				else if(indB != -1 && indB < indR)
				{
					output += indB-1;
					input = input.substring(indB);
					continue;
				}
			}
			
			//Blue
			else if(indB == 0)
			{
				//If blue is the only color remaining
				if(indR == -1 && indG == -1)
				{
					output += input.length()-1;
					break;
				}
				
				//Only green remains
				if(indR == -1 && indG != -1)
				{
					output += indG-1;
					input = input.substring(indG);
					continue;
				}
				
				//Only Red remains
				else if(indG == -1 && indR != -1)
				{
					output += indR-1;
					input = input.substring(indR);
					continue;
				}
				
				//Red is the next color and exists in the string
				else if(indR != -1 && indR < indG)
				{
					output += indR-1;
					input = input.substring(indR);
					continue;
				} 
				
				//Green is the next color
				else if(indG != -1 && indG < indR)
				{
					output += indG-1;
					input = input.substring(indG);
					continue;
				}
			}
			
			System.out.println("Error");
			break;
		}
		
		System.out.print(output);
	}
}
