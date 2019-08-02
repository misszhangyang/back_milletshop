package milletshop.millet.config.redisConfig;

import org.apache.commons.logging.Log;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class MessgaeReceiver {

    public static Logger logger  = (Logger) LoggerFactory.getLogger(MessgaeReceiver.class);

    private CountDownLatch latch;

    @Autowired
    public MessgaeReceiver(CountDownLatch latch){
        this.latch = latch;
    }


    public void  receiverMessage(String msg){
        logger.info(msg);
        latch.countDown();
    }
}
