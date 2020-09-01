//package webtecass2pckg;
import java.util.*;
public class ques2 {
	static void countSort(int[] arr) 
	{ 
		int max = Arrays.stream(arr).max().getAsInt(); 
		int min = Arrays.stream(arr).min().getAsInt(); 
		int range = max - min + 1; 
		int count[] = new int[range]; 
		int output[] = new int[arr.length]; 
		for (int i = 0; i < arr.length; i++) 
			count[arr[i] - min]++; 
		for (int i = 1; i < count.length; i++) 
			count[i] += count[i - 1]; 
		for (int i = arr.length - 1; i >= 0; i--) 
		{ 
			output[count[arr[i] - min] - 1] = arr[i]; 
			count[arr[i] - min]--; 
		} 

		for (int i = 0; i < arr.length; i++) 
			arr[i] = output[i]; 
	} 
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("enter the size of the array");
		n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("enter the elements ranging from 0 till 20");
		for(int i=0;i<n;++i) 
			arr[i] = sc.nextInt();
		System.out.println("the sorted array is:");
		countSort(arr);
		for(int i=0;i<n;++i)
			System.out.print(arr[i]+" ");
	}


}
