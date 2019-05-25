package milletshop.millet.mvcconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 异步线程配置类
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor(){
        //定义线程池
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //定义核心数
        threadPoolTaskExecutor.setCorePoolSize(10);
        //定义最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(30);
        //定义队列数目
        threadPoolTaskExecutor.setQueueCapacity(2000);
        //初始化
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
