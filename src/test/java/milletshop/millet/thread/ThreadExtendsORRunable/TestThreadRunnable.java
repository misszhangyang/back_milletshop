package milletshop.millet.thread.ThreadExtendsORRunable;

public class TestThreadRunnable extends Thread{

    private String name;
    private int i;
    private final static int MAX = 50;

    public TestThreadRunnable(String name){
        this.name = name;
    }

    @Override
    public void run(){
        while(i < MAX){
            System.out.println(Thread.currentThread().getName() + "the thread " +  i);
            i++;
        }
    }

    public void print(){
        System.out.println("this is" + this.name);
    }


    public static void main(String[] args) {
        TestThreadRunnable testThreadRunnable1 = new TestThreadRunnable("1");
        TestThreadRunnable testThreadRunnable2 = new TestThreadRunnable("2");
        TestThreadRunnable testThreadRunnable3 = new TestThreadRunnable("3");
        testThreadRunnable1.start();
        testThreadRunnable2.start();
        testThreadRunnable3.start();
    }

}
