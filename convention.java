//package usaco2018december;
//Time 3 hours 30 min
//All ten cases work
//Difficulty 9/10
//This was my first time ever doing binary search for the answer and I feel like this will come in handy later on. I feel like I gained another skill in coding
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class convention{
	
	static int N;
	static int M;
	static int C;
	
	static int[]ArrivalTimes;
	
	static boolean simulate(int MaxTime) {
		
		int CowLinePointer=0;
		
		for(int EachBus=1; EachBus<=M; EachBus++) {
			
			
			
			for(int EachCow=1; EachCow<C; EachCow++) {
				
				if(EachCow+CowLinePointer>=N) {
					return true;
				}
				
				
				if(ArrivalTimes[CowLinePointer+EachCow]-ArrivalTimes[CowLinePointer]>MaxTime) {
					CowLinePointer+=EachCow;
					break;
				}
				if(EachCow==C-1) {
					CowLinePointer+=EachCow+1;
				}
				
			}
			
			
			
		}
		
		if(CowLinePointer>=N) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	static int BinarySearch(int start, int end) {
		int Start=start;
		int End=end;
		
		if(simulate((start+end)/2)&&!simulate(((start+end)/2)-1)) {
			return (start+end)/2;
		}
		else if(simulate((start+end)/2)){
			return BinarySearch(Start, (Start+End)/2 );
		}
		else {
			return BinarySearch((Start+End)/2, End );
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException{
	
		Scanner in = new Scanner(new File("convention.in"));
		N=in.nextInt();
		M=in.nextInt();
		C=in.nextInt();
		
		ArrivalTimes=new int[N];
		for(int i=0; i<N; i++) {
			ArrivalTimes[i]=in.nextInt();
		}
		Arrays.sort(ArrivalTimes);
		in.close();
		
		int Max = BinarySearch(0, ArrivalTimes[N-1]);
		
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		pw.println(Max);
		pw.close();
		System.out.println(Max);
		
	}
	
	
	
	
	
}