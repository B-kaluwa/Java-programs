public class Thread_priorities {
    public static void main(String[] args) {
    Thread highPriorityThread = new Thread(new HighPriorityRunnable());
    Thread lowPriorityThread = new Thread(new LowPriorityRunnable());

    // Set thread priorities
    highPriorityThread.setPriority(Thread.MAX_PRIORITY);
    lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

    highPriorityThread.start();
    lowPriorityThread.start();
}
}

class HighPriorityRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("High priority thread - Iteration " + (i + 1));
        }
    }
}

class LowPriorityRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Low priority thread - Iteration " + (i + 1));
        }
    }
}
