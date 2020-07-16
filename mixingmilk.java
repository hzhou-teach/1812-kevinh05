//package usaco2018december_bronze;
//All ten cases work
//40 min
//Difficulty 3/10
//Thought this question was pretty simple I just ran through all 100 pours
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class mixingmilk
{
	

	
	public static void main(String[] args) throws IOException
	{
		

		Scanner in = new Scanner(new File("mixmilk.in"));
		
		int c1=in.nextInt();
		int m1=in.nextInt();
		
		int c2=in.nextInt();
		int m2=in.nextInt();
		
		int c3=in.nextInt();
		int m3=in.nextInt();
		in.close();
		
		int pointer=1;
		for(int i=0; i<100; i++) {
			
			if(pointer==1) {
			//pours 1 to 2
			if (m1+m2>c2) {
				m1=(m1+m2)-c2;
				m2=c2;
			}
			else {
				m2=m1+m2;
				m1=0;
			}
			pointer=2;
			}
			
			else if(pointer==2) {
			//pours 2 to 3
			if (m2+m3>c3) {
				m2=m2+m3-c3;
				m3=c3;
			}
			else {
				m3=m2+m3;
				m2=0;
			}
			pointer=3;
			}
			
			else if(pointer==3) {
			//pours 3 to 1
			if (m3+m1>c1) {
				m3=m3+m1-c1;
				m1=c1;
			}
			else {
				m1=m3+m1;
				m3=0;
			}
			pointer=1;
			}
			
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		
		
		pw.println(m1);
		pw.println(m2);
		pw.println(m3);
		pw.close();

	}

}
