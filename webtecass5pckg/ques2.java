//package webtecass5pckg;

class Count{
	static int maximum;
	static int no;
	
	public void run(int begin, int end) {	
		for(int i=begin; i<=end; i++)
		{
			int count=1;
			for(int j=1; j<=(i/2)+1; j++)
			{
				if(i%j==0)
					count++;
			}
			synchronized(this) {
				if(count>maximum)
				{
					maximum=count;
					no= i;
				}
			}		
		}
	}
}


class My_thread extends Thread{
	Count C;
	int begin;
	int end;

	My_thread(Count C, int begin, int end){
		this.C= C;
		this.begin= begin;
		this.end= end;
	}
	
	public void run() {
		C.run(begin, end);
	}
	
}

public class ques2 {
	
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		Count C= new Count();
		My_thread thread_array[]= new My_thread[100];
		int j=0;
		for(int i= 100; i<=10000; i+=100) {
			thread_array[j]= new My_thread(C,i-99,i);
			thread_array[j].start();
			j++;
		}
		
		for(int i=0; i<100; i++)
		{
			try {
				thread_array[i].join();
			}
			catch(Exception e) {}
		}
		long end = System.currentTimeMillis();
		System.out.println("Range- 1 to 10000");
		System.out.println("The maximumimum number of divisors: "+C.maximum);
		System.out.println("Of no: "+C.no);
		System.out.println("Time elapsed: "+ (end - begin) +" milli-seconds");
	}	
}
