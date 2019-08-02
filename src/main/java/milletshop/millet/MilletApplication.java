package milletshop.millet;

import org.apache.ibatis.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.CountDownLatch;


@SpringBootApplication
@EnableCaching
@EnableScheduling
public class MilletApplication {

    protected static Logger logger = (Logger) LogFactory.getLog(MilletApplication.class);

//    ServerSocket socket;
//
//    {
//        try {
//            socket = new ServerSocket(8080);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    class milletshop{
//        protected  void test(){
//            System.out.println("dewew");
//        }
//    }


    public static void main(String[] args) throws InterruptedException {

//        Thread thread = new Thread(() -> {
//            System.out.println("the new thread is start");
//        });
//
//        thread.start();
//
//        System.out.println("Helllo,this is Main Thread");

//        SpringApplication.run(MilletApplication.class, args);
        ApplicationContext ctx =  SpringApplication.run(MilletApplication.class, args);

        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);

        logger.info("Sending message...");
        template.convertAndSend("chat", "Hello from Redis!");

        latch.await();

        System.exit(0);

//

//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("the hookThread is start---");
//        }));

    }

}
