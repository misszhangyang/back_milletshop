package milletshop.millet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.net.ServerSocket;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class MilletApplication {

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


    public static void main(String[] args) {

//        Thread thread = new Thread(() -> {
//            System.out.println("the new thread is start");
//        });
//
//        thread.start();
//
//        System.out.println("Helllo,this is Main Thread");

        SpringApplication.run(MilletApplication.class, args);
//

//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("the hookThread is start---");
//        }));

    }

}
