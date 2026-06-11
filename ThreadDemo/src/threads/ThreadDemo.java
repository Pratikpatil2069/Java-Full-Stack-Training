package threads;

class MyThread extends Thread {
     synchronized public void run() {
    	for( int i=1;i<=5;i++) {
    		System.out.println("Downloading...");

    	}
    }
}

public class ThreadDemo {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();

//        t1.start();
//        try {
//        	t1.join();
//        }catch(Exception e) {
//        	System.out.println(e);
//        }
//        t2.start();
//        try {
//        	t2.join();
//        }catch(Exception e) {
//        	System.out.println(e);
//        }
//        t3.start();
//        try {
//        	t3.join();
//        }catch(Exception e) {
//        	System.out.println(e);
//        }
//        t4.start();
//        t1.setName("thread 1");
//        t2.setName("thread 2");
//        t3.setName("thread 3");
//        t4.setName("thread 4");
//        
//        t1.setPriority(Thread.MAX_PRIORITY);
//        t2.setPriority(Thread.MIN_PRIORITY);
//        t3.setPriority(1);
//        t4.setPriority(2);
//        
//	      t1.start();
//	      t2.start();
//	      t3.start(); 
//	      t4.start();
        
		  t1.start();
		  System.out.println("___________________");
	      t2.start();
	      System.out.println("___________________");
	      t3.start(); 
	      System.out.println("___________________");
	      t4.start();
	      System.out.println("___________________");
        
       
    }
}
