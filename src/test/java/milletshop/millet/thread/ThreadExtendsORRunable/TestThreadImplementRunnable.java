package milletshop.millet.thread.ThreadExtendsORRunable;

public class TestThreadImplementRunnable implements Runnable {

    private String name;
    private int i;
    private static final int MAX = 50;

    @Override
    public void run() {
        while(i < MAX){
            System.out.println(Thread.currentThread().getName() + "the Thread " + i);
            i++;
        }
    }

    public static void main(String[] args) {
        TestThreadImplementRunnable testThreadImplementRunnable = new TestThreadImplementRunnable();
        Thread thread1 = new Thread(testThreadImplementRunnable,"thread1");
        Thread thread2 = new Thread(testThreadImplementRunnable,"thread2");
        Thread thread3 = new Thread(testThreadImplementRunnable,"thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
