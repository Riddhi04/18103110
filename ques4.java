//package webtecass1pckg;

import java.util.*;
import java.util.Arrays;

public class ques4 {
	
	public static boolean isAnagram(String s1, String s2) {
		if(s1.length()!=s2.length())
			return false;
		char c1[] = s1.toCharArray();
		Arrays.sort(c1);
		char c2[] = s2.toCharArray();
		Arrays.sort(c2);
		for(int i=0;i<s1.length();++i) {
			if(c1[i]!=c2[i])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println("enter string 1");
		Scanner sc = new Scanner(System.in);		
		String s1 = sc.nextLine();
		System.out.println("enter string 2");
		String s2 = sc.nextLine();
		if(isAnagram(s1,s2))
			System.out.println("Its an Anagram!");
		else
			System.out.println("Not an Anagram!");
	}

}
