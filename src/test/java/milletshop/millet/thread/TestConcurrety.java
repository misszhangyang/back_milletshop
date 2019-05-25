package milletshop.millet.thread;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java模拟多线程高并发
 * 原文地址：https://blog.csdn.net/u010642004/article/details/50042781
 * @author Administrator
 *
 */
public class TestConcurrety {
    static int count = 0;
    // 总访问量是clientNum，并发量是threadNum
    int threadNum = 4;
    int clientNum = 200;

    float avgExecTime = 0;
    float sumexecTime = 0;
    long firstExecTime = Long.MAX_VALUE;
    long lastDoneTime = Long.MIN_VALUE;
    float totalExecTime = 0;

    public static void main(String[] args) {
        new TestConcurrety().run();
        System.out.println("finished!");
    }

    public void run() {

        final ConcurrentHashMap<Integer, ThreadRecord> records = new ConcurrentHashMap<Integer, ThreadRecord>();

        // 建立ExecutorService线程池，threadNum个线程可以同时访问
        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        // 模拟clientNum个客户端访问
        final CountDownLatch doneSignal = new CountDownLatch(clientNum);

        for (int i = 0; i < clientNum; i++) {
            System.out.println("开始执行循环线程");
            Runnable run = new Runnable() {
                public void run() {
                    int index = getIndex();
                    long systemCurrentTimeMillis = System.currentTimeMillis();
                    try {
//                        String sendGet = HttpClientUtil.sendGet("http://localhost:8080/Dima3773Web/Simulate", "");
                        System.out.println(new TestConcurrety().objectIsEqual(Singleton.getInstance()));
//                        System.out.println(System.currentTimeMillis());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    records.put(index, new ThreadRecord(systemCurrentTimeMillis, System.currentTimeMillis()));
                    doneSignal.countDown();// 每调用一次countDown()方法，计数器减1
                }
            };
            exec.execute(run);
        }
        System.out.println("主线程main的执行部分");
        try {
            // 计数器大于0 时，await()方法会阻塞程序继续执行
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 获取每个线程的开始时间和结束时间
         */
        for (int i : records.keySet()) {
            ThreadRecord r = records.get(i);
            sumexecTime += ((double) (r.endTime - r.startTime)) / 1000;

            if (r.startTime < firstExecTime) {
                firstExecTime = r.startTime;
            }
            if (r.endTime > lastDoneTime) {
                this.lastDoneTime = r.endTime;
            }
        }

        this.avgExecTime = this.sumexecTime / records.size();
        this.totalExecTime = ((float) (this.lastDoneTime - this.firstExecTime)) / 1000;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(4);

        System.out.println("======================================================");
        System.out.println("线程数量:\t\t" + threadNum);
        System.out.println("客户端数量:\t" + clientNum);
        System.out.println("平均执行时间:\t" + nf.format(this.avgExecTime) + "秒");
        System.out.println("总执行时间:\t" + nf.format(this.totalExecTime) + "秒");
        System.out.println("吞吐量:\t\t" + nf.format(this.clientNum / this.totalExecTime) + "次每秒");
    }

    public static int getIndex() {
        return ++count;
    }

    public boolean objectIsEqual(Singleton singleton){
        List<Singleton> lists = new ArrayList<>();
        if(lists.size() < 2){
            lists.add(singleton);
        }
        if(lists.size() == 2 ){
            lists.add(singleton);
            return lists.get(1) == lists.get(2);
        }
        else{
            lists.removeAll(lists);
        }
        return true;
    }

}

class ThreadRecord {
    long startTime;
    long endTime;

    public ThreadRecord(long st, long et) {
        this.startTime = st;
        this.endTime = et;
    }
}

final class Singleton{
    public static Singleton instance = null;
    public Singleton(){

    }
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}