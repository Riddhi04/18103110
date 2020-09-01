//package webtecass2pckg;

import java.util.*;

public class ques5 {
	
	public static void union(int X[], int Y[], int n)
	{
		boolean un[]= new boolean[n];		
		for(int i=0; i<X.length; i++)
			un[X[i]]= true;
		for(int i=0; i<Y.length; i++)
			un[Y[i]]= true;		
		System.out.print("X UNION Y- ");	    
		for(int i=0; i<n ; i++)
			if(un[i])
			System.out.print(i+" ");
		System.out.println();
	}
	
	public static void intersection(int X[], int Y[], int n)
	{
		boolean intrsct[]= new boolean[n];
		
		for(int i=0; i<X.length; i++)
			intrsct[X[i]]= true;
		System.out.print("X INTERSECTION Y- ");		
		for(int i=0; i<Y.length; i++)
			if(intrsct[Y[i]])
				System.out.print(Y[i]+" ");	
		System.out.println();
	}
	
	public static void complement(int X[], int n)
	{
		boolean comp[]= new boolean[n];
		for(int i=0; i<X.length; i++)
			comp[X[i]]= true;		
		System.out.print("COMPLEMENT- ");		
		for(int i=0; i<n; i++)
			if(comp[i]==false)
				System.out.print(i+" ");	
		System.out.println();
	}
	
	public static void main(String[] args) {
		int n;
		Scanner input = new Scanner(System.in);
		System.out.println("Input numbers of elements in universe ");
		n= input.nextInt();
	    System.out.print("No. of elements in Set X: ");
	    int count1= input.nextInt();
	    System.out.println("Enter the elements of Set X");
	    int X[]= new int[count1];
	    Set<Integer> set_X= new HashSet<Integer>();
	    Set<Integer> set_Y= new HashSet<Integer>();   
	    for(int i=0; i<count1; i++)
	    {
	    	X[i]= input.nextInt();
	    	set_X.add(X[i]);
	    }
	    System.out.print("No. of elements in Set Y: ");
	    int count2= input.nextInt();
	    System.out.println("Enter the elements of Set Y!");
	    int Y[]= new int[count2];
	    for(int i=0; i<count2; i++)
	    {
	    	Y[i]= input.nextInt();
	    	set_Y.add(Y[i]);
	    }
	    input.close();
	    long start1= System.nanoTime();
	    System.out.println("Arrays: ");
	    union(X, Y, n);
	    intersection(X,Y,n);
	    complement(X, n);
	    complement(Y, n) ;
	    long end1= System.nanoTime();	    
	    long start2= System.nanoTime();
	    System.out.println("Using Hash_Set: "); 
	    // union  
        Set<Integer> union = new HashSet<Integer>(set_X);  
        union.addAll(set_Y);  
        System.out.print("X UNION Y: ");
        System.out.println(union);   
        // intersection  
        Set<Integer> intersection = new HashSet<Integer>(set_X);  
        intersection.retainAll(set_Y);  
        System.out.print("X INTERSECTION Y: ");  
        System.out.println(intersection);  	    
	    //Complement
	    Set<Integer> Universe= new HashSet<Integer>();
	    for(int i=0; i<n; i++)
	    	Universe.add(i);
	    Set<Integer> differenceSet = new HashSet<Integer>(Universe);
	    differenceSet.removeAll(set_X);
        System.out.print("Complement of Set X: ");  
        System.out.println(differenceSet);       
        differenceSet = new HashSet<Integer>(Universe);
	    differenceSet.removeAll(set_Y);
        System.out.print("Complement of Set Y: ");  
        System.out.println(differenceSet);
        long end2= System.nanoTime();
	    System.out.println("Cost of operations using ARRAY: "+ (end1-start1) + " ns");
	    System.out.println("Cost of operations using HASH_SET: "+ (end2-start2) + " ns");
	}
}
