//package usaco2018december_bronze;
//50 min
//Difficulty 6/10
//All test cases work
//I used brute force for this one and found all the possible combinations of buckets with unique sums in 4 switches.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class backforth
{
	
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("backforth.in"));
		
		
		int[] farm1 = new int[10];
		int[] farm2 = new int[10];
		
		for(int i=0; i<10; i++) {
			farm1[i]=in.nextInt();
		}
		for(int i=0; i<10; i++) {
			farm2[i]=in.nextInt();
		}
		ArrayList<Integer> possibleAmounts = new ArrayList<Integer>();

		int[] Day1tempFarm1=farm1.clone();
		int[] Day1tempFarm2=farm2.clone();
		
		//--------------------------------------------------------------------------------------------------------
		for(int Day1=0; Day1<10; Day1++) {
			
			
			
			//----------------------------------------------------------------------------------------------------------------
			for(int Day2=0; Day2<10; Day2++) {
				
				int[] Day2tempFarm1=farm1.clone();
				int[] Day2tempFarm2=farm2.clone();
				
				int temp=farm1[Day1];
				farm1[Day1]=farm2[Day2];
				farm2[Day2]=temp;
				
				//---------------------------------------------------------------------------------------------------------------------
				for(int Day3=0; Day3<10; Day3++) {
					
					int[] Day3tempFarm1=farm1.clone();
					int[] Day3tempFarm2=farm2.clone();
					
					//--------------------------------------------------------------------------------------------------------------------------
					for(int Day4=0; Day4<10; Day4++) {
						int[] Day4tempFarm1=farm1.clone();
						int[] Day4tempFarm2=farm2.clone();
						temp = farm1[Day3];
						farm1[Day3]=farm2[Day4];
						farm2[Day4]=temp;
						
						//find the total milk in farm1
						int Farm1Total=0;
						for(int element:farm1) {
							Farm1Total+=element;
						}
						//find out if the total is already a possibility
						if(possibleAmounts.isEmpty()||!possibleAmounts.contains(Farm1Total)) {
							possibleAmounts.add(Farm1Total);
						}
						
						//reset the farm
						farm1=farm1.clone();
						farm2=farm2.clone();
						
						farm1=Day4tempFarm1.clone();
						farm2=Day4tempFarm2.clone();
						
					}
					
					farm1=Day3tempFarm1.clone();
					farm2=Day3tempFarm2.clone();
				}
				
				farm1=Day2tempFarm1.clone();
				farm2=Day2tempFarm2.clone();
			}
			
			farm1=Day1tempFarm1.clone();
			farm2=Day1tempFarm2.clone();
			
		}
		
		//-----------------------------------------------------------------------------------------------------------------------------------
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		pw.println(possibleAmounts.size());
		pw.close();
		
	}
}
