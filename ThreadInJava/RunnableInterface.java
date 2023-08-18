package ThreadInJava;

class NewThread implements Runnable {
    Thread t;

    NewThread() {
        t = new Thread(this, "Child Thread");
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i >= 0; i--) {
                System.out.println("Child Thread = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Child Interrupted");
        }
        System.out.println("Existing Child Thread");
    }
}

/**
 * RunnableInterface
 */
public class RunnableInterface {
    public static void main(String[] args) {
        new NewThread();
        try {
            for (int i = 5; i >= 0; i--) {
                System.out.println("Main Thread = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted");
        }
        System.out.println("Existing Main Thread");
    }

}