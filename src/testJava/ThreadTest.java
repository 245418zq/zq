package testJava;

public class ThreadTest extends Thread{

	int k=0;
	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
		ThreadTest t3 = new ThreadTest();
		ThreadTest t4 = new ThreadTest();
		ThreadTest t5 = new ThreadTest();
		for(int i=1;i<6;i++){
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
		}
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		k++;
		System.out.println(k);
		System.out.println(this.currentThread());
	}
	
}
