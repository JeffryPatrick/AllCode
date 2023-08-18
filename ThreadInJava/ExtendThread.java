package ThreadInJava;

class NewExtendThread extends Thread {

    NewExtendThread() {
        super("Demo Thread");
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Child Interrupted");
        }
        System.out.println("Exiting Child Thread");
    }
}

/**
 * ExtendThread
 */
public class ExtendThread {
    public static void main(String[] args) {
        new NewExtendThread();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Exiting Main Thread");
    }

}