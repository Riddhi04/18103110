package webtecass5pckg;

import java.util.*;
	
class MyThread implements Runnable{
	public void run() {
		for (int i=1;i<=100;++i)
			if(i%10==0)
				System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(Exception error) {
			}
	}
}

public class ques1{ 
	public static void main(String args[]) {
		MyThread obj = new MyThread();
		Thread thread = new Thread(obj);
		thread.start();	
	}	
}
