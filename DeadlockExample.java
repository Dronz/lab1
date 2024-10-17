package labexam.java;

public class DeadlockExample {
	public static void main(String[] args) {
		final Object resource1 = new Object();
		final Object resource2 = new Object();
		Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 4: Locked resource 5");

                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource2) {
                    System.out.println("Thread 5: Locked resource 6");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 5: Locked resource 6");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource1) {
                    System.out.println("Thread 4: Locked resource 5");
                }
            }
        });

        thread1.start();
        thread2.start();
    }


		

	


}