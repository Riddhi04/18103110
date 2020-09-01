package webtecass2pckg;

import java.util.*;

public class ques6 {
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter number ");
        int x = obj.nextInt();

        System.out.println("Hailstone sequence: " + x);
        int ct = 0;
        while(x!=1 && ct<Integer.MAX_VALUE && x<Integer.MAX_VALUE && x>0){
            if(x%2!=0)
                x=x*3+1;
            else
                x/=2;
            System.out.println(x);
            ct++;
        }
        if(x==1)
            System.out.println("No. of steps: " + ct);
        else if(x==Integer.MAX_VALUE || x<0)
            System.out.println("Integer overflow");
        else
            System.out.println("No of steps maxed out");
    }
}
