#package webtecass1pckg;
import java.util.*;

public class ques2 {
	
	public static String starconvt(String text, String word) {
		String newtext[] = text.split(" ");
		int index = 0;
		for(String str: newtext) {
			if(str.compareTo(word)==0) {
				String rep = "";
				rep += str.charAt(0);
				for(int i=1;i<str.length();++i)
					rep += "*";
				newtext[index] = rep;
			}
			++index;
		}
		
		String ans="";
		for(String s: newtext) {
			ans+= s;
			ans+= " ";
		}
		ans = ans.trim();
		return ans;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("enter a paragraph");
		String para = sc.nextLine();
		String words[] = {"world", "global"};
		for(String str: words) {
			para = starconvt(para, str);
		}
		System.out.println(para);
	}
}
