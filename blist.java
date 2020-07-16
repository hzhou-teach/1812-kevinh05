//package usaco2018december_bronze;
//30 min
//Difficulty 3/10
//All test cases work
//This one was simple all you needed to do was find the overlapped time where the most cows required the most buckets

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
class log{
	public int start;
	public int end;
	public int bucketsNeeded;
	
	log(int start, int end, int bucketsNeeded){
		this.start=start;
		this.end=end;
		this.bucketsNeeded=bucketsNeeded;
	}
}
public class blist
{
	

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("blist.in"));
		int N=in.nextInt();
		
		log[] list = new log[N];
		
		for(int i=0; i<N; i++) {
			list[i]=new log(in.nextInt(), in.nextInt(), in.nextInt());
		}
		
		int[] timeline=new int[1000];
		
		//load all the bucketsNeeded into a timeline
		for(log element:list) {
			for(int i=element.start-1; i<element.end; i++) {
				timeline[i]=timeline[i]+element.bucketsNeeded;
			}
		}
		
		//find the point where the max buckets are needed
		int MAX=0;
		for(int i=0; i<1000; i++) {
			if(timeline[i]>MAX) {
				MAX=timeline[i];
			}
		}
	
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
		pw.println(MAX);

		
		pw.close();
		
		

	}
}
