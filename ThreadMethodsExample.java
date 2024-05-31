class MyThread extends Thread {
    public void run() {
        // Display thread information
        displayThreadInfo("Thread started");

        // Sleep for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display thread information after sleep
        displayThreadInfo("Thread after sleep");

        // Yield the thread
        Thread.yield();

        // Display thread information after yielding
        displayThreadInfo("Thread after yielding");

        // Interrupt the thread
        interrupt();

        // Display thread information after interrupting
        displayThreadInfo("Thread after interrupt");

        // Check if the thread is alive
        if (isAlive()) {
            displayThreadInfo("Thread is still alive");
        } else {
            displayThreadInfo("Thread has died");
        }
    }

    private void displayThreadInfo(String message) {
        System.out.println(Thread.currentThread().getName() + ": " + message);
    }
}

public class ThreadMethodsExample {
    public static void main(String[] args) {
        // Create and start a new thread
        MyThread myThread = new MyThread();
        myThread.start();

        // Join the main thread with myThread
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display information after the thread has finished
        System.out.println(Thread.currentThread().getName() + ": Main thread after join");
    }
}
