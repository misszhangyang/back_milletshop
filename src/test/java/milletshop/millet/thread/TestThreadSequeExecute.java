package milletshop.millet.thread;

import ch.qos.logback.core.util.TimeUtil;
import org.apache.activemq.util.TimeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * 模拟线程按顺序执行
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestThreadSequeExecute {

    protected  static Log log = LogFactory.getLog(TestThreadSequeExecute.class);

    @Test
    public void testThreadOrRunnable(){

    }



    /**
     * 测试守护线程的作用
     * @param args
     */
    @Test
    public static void main(String[] args) {

        System.out.println("main线程开始启动");
        Thread thread = new Thread("测试线程"){
            @Override
            public void run(){
                while(true){
                    System.out.println("测试线程开始执行");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
         thread.setDaemon(true);
        //  如何没有将测试线程设置成守护线程，则start之后的测试线程将会一直执行，知道栈溢出，
//        如果将他设置成守护线程，则当main线程执行结束之后，就会结束
        thread.start();
        System.out.println("main线程执行结束");


    }

    @Test
    public void test(){
//         getThread();
        implementRunnable();
    }

    private void implementRunnable(){

        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                enjoyMusic();
            }
        };
        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                enjoyCoffee();
            }
        };

        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);

        System.out.println(thread1.getName());
        thread1.start();
        thread2.start();
    }

    public void getThread(){
        new Thread(){
            @Override
            public void  run(){
                enjoyMusic();
            }
        }.start();
        enjoyCoffee();
    }

    private void enjoyCoffee() {
        for(;;){
            System.out.println("pleace enjoy Coffee");
            sleep(1);
        }
    }

    private void enjoyMusic() {
        for(;;){
            System.out.println("please enjoy music");
            sleep(1);
        }
    }

    private void sleep(int millects){
        try{
            TimeUnit.SECONDS.sleep(millects);
        }catch(InterruptedException e){
            log.info(e.toString());
        }

    }

    //线程中的start,run方法设计体现了模板设计模式，下面是一个实例（模板设计模式）
    @Test
    public void testThread(){
        TempleateMethod thread = new childTempleatMethod("11");
        thread.print();

        TempleateMethod thread2 = new childTempleatMethod1("22");
        thread2.print();
    }


    abstract class TempleateMethod{
        public void print(){
            System.out.println("======================");
            showMessage();
            System.out.println("======================");
        }

        public  abstract void showMessage();
    }

    class childTempleatMethod extends  TempleateMethod{

        private String message;

        public childTempleatMethod(String mes){
            this.message = mes;
        }

        @Override
        public void showMessage() {
            System.out.println("childTempleatMethod" + message);
        }
    }

    class childTempleatMethod1 extends  TempleateMethod{

        private String message;

        public childTempleatMethod1(String mes){
            this.message = mes;
        }
        @Override
        public void showMessage() {
            System.out.println("childTempleatMethod" + message);
        }
    }

    class TemplateMethodInfo{

        public void print(){
            System.out.println("---------------------");
            printInfo();
            System.out.println("-----------------");
        }

        public void printInfo() {
        }
    }

    @Test
    public void testInfo(){
        TemplateMethodInfo templateMethodInfo = new TemplateMethodInfo(){
            @Override
            public void printInfo() {
                System.out.println("this is templateMethodInfo print");
            }
        };
        templateMethodInfo.print();


        TemplateMethodInfo templateMethodInfo1 = new TemplateMethodInfo(){
            @Override
            public void printInfo(){
                System.out.println("this is templateMethodInfo1 print");
            }
        };
        templateMethodInfo1.print();
    }




}



