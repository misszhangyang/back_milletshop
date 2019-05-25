package milletshop.millet.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestThread{
    @Test
    public void getMaxSum(){
        int[] arr = {-5,-2,-3,-4,-9,-5};
        System.out.println(getSunone(-9,arr));
        System.out.println("-----------------------------------");
        System.out.println(testArr1(arr));
    }

    public int testArr(int[] arr){
        int maxSUn = arr[1];
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                int sum = 0;
                for (int k = i; k <= j;k++){
                    sum += arr[k];
                }
                if(sum > maxSUn)
                    maxSUn = sum;
            }
        }
        return maxSUn;
    }

    public int testArr1(int[] arr){
        int maxSum = arr[1];
        for (int i = 0;i < arr.length; i ++){
            int sum = 0;
            for(int j = i; j < arr.length; j ++){
                sum += arr[j];
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public int testArr2(int[] arr){
        int maxSum = arr[1], sum = 0;
        for (int i = 0 ;i < arr.length; i ++){
            sum += arr[i];
            if(sum > maxSum)
                maxSum = sum;
            else if (sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
    
    //折半查找
    public int getSunone(int x,int[] arr1){
        int samll = 0;
        int large = arr1.length;
        while(samll < large){
            int middle  = arr1[samll + large / 2];
            if (x < middle){
                samll = samll + 1;
            }
            if(x > middle){
                large = large - 1;
            }else{
                return  samll + large / 2;
            }
        }
        return 0;
    }

    //求倆個證書數的最大公因數
    public int getMaxCommonFactor(int x,int y){
        while( y != 0){
            int ren = x % y;
            x = y;
            y = x;
        }
        return x;
    }


    //验证compareTo方法
    public void testContains(){

        List list = new ArrayList();
        list.contains(3);
    }

//輸入abc,輸出acb,abc,bac,bca,cba,cab
//    public List<String> getListString(String str){
//        List<String> listStrs = new  ArrayList<>();
//        List<Character> listChars = new ArrayList<>();
//        for(int i = 0; i < str.length(); i++){
//            char s = str.charAt(i);
//            listChars.add(s);
//        }
//        for (int i = 0; i < listChars.size(); i ++) {
//            while()
//        }
//        return listStrs;
//    }

    //輸出N表示的二進制

    /**
     * 钩子线程Runtime.getRuntime.addShutdownHook(new Thread(){})
     */
    @Test
    public void testThreadHook(){
        //在线程结束时启动钩子线程，将线程启动时创建的文件删除，防止程序无限重启
        String filePath = "../back/src/main/resources/file";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }

        String fileName = "test.lock";
        File filePathName  = new File(filePath + "/" + fileName);
        try {
            FileWriter fw = new FileWriter(filePathName);
            fw.write("这是测试 " + Thread.currentThread().getName() + " 线程的HookThread函数");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if(filePathName.exists()){
               filePathName.delete();
            }
        }));
        System.out.println("测试函数 " +Thread.currentThread().getName() + " 开始执行");
    }

    @Test
    public void testEventQueue(){
        final EventQueue eventQueue = new EventQueue(6);
        new Thread(() -> {
            for(;;){
                eventQueue.offer(new EventQueue.Event());
            }
        },"producer").start();

        new Thread(() -> {
            for(;;){
                eventQueue.take();
                try{
                    TimeUnit.MILLISECONDS.sleep(10);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"Consumer").start();
    }

    @Test
    public void threadTest1(){
        new Thread(() -> enjoyMusic()).start();
        broweNews();
    }

    private void broweNews() {
        for(;;){
            System.out.println("Uh-hh,the good news");
            System.out.println(Thread.currentThread().getName());
            sleep(1);
        }
    }

    private void sleep(int secound) {
        try{
            TimeUnit.SECONDS.sleep(secound);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    private void enjoyMusic() {
        for(;;){
            System.out.println("Uh-huhu,the nice music");
//            System.out.println(Thread.currentThread().getName());
            sleep(1);
        }
    }
}

class ThreadCounter extends Thread{
    final  static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String args[]){
        try{
            while(true){
                new ThreadCounter().start();
                currentThread();
            }
        }catch(Throwable throwable){
            System.out.println("failed: At=>" + counter.get());
        }
    }

    @Override
    public void run(){
        try{
            System.out.println("The "+ counter.getAndIncrement() + " thread be created");
            TimeUnit.MINUTES.sleep(10);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}