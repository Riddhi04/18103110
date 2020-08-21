package webtecass1pckg;

import java.util.*;

public class ques1 {
	
	public static boolean iszeros(int a[]) {
		for(int i=0;i<256;++i)
			if(a[i]!=0)
				return false;
		return true;
	}
	
	public static int count(String main,String sub,int a[]) {
		if(sub.length()>main.length() || sub.length()==0)
			return 0;
		int ct=0;
		for(int i=0;i<sub.length();++i)
			a[main.charAt(i)]--;
		if(iszeros(a))
			ct++;
		for(int i=sub.length();i<main.length();++i) {
			a[main.charAt(i)]--;
			a[main.charAt(i-sub.length())]++;
			if(iszeros(a))
				ct++;
		}
		return ct;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the main string");
		String mainstring = sc.nextLine();
		System.out.print("enter the sub string");
		String substring = sc.nextLine();		
		int a[] = new int[256];
		for(int i=0;i<substring.length();++i)
			a[substring.charAt(i)]++;
		System.out.println("count = "+ count(mainstring,substring,a));
		
	}
}
