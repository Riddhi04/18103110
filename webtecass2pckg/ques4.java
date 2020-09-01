//package webtecass2pckg;

import java.util.*;

public class ques4 {
	
	public static long sum(int i)
	{
		long sum=0;
		for(int j=i; j>=1; j--)
		{
			sum+= j;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Processing will take time");		
		long sum= sum(Integer.MAX_VALUE);		
		System.out.println("Loading...");		
		for(int i=Integer.MAX_VALUE; i>=1; i--)
		{
			long square= (long)i*(long)i;
			if(square==sum)
			{
				System.out.println("Answer "+i);
				break;
			}
			sum= sum- (long)i;
			if(i==1)
				System.out.println("Not possible");
		}
	}
}

