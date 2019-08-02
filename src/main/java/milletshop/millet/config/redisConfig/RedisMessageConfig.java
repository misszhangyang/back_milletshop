package milletshop.millet.config.redisConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

/**
 * redis消息队列配置
 */
@Configuration
public class RedisMessageConfig {

    @Bean
    public MessgaeReceiver messgaeReceiver(CountDownLatch latch){
         return new MessgaeReceiver(latch);
    }

    @Bean
    public CountDownLatch latch(){
        return new CountDownLatch(1);
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(){
        return new StringRedisTemplate();
    }


    /**
     * redis消息监听容器 连接工厂
     * @param redisConnectionFactory
     * @param messageListenerAdapter
     * @return
     */
    @Bean
    public RedisMessageListenerContainer messageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter){
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        //监听容器中设置连接工厂
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        //监听容器中设置消息监听类型
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter,(Collection) Collections.singleton(new PatternTopic("1")));
        return redisMessageListenerContainer;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MessgaeReceiver receiver) {
        return new MessageListenerAdapter();
    }
}
