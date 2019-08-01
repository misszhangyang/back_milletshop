package milletshop.millet.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisDao {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setDataToRedis(String key,String value){
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        ops.set(key,value,1, TimeUnit.MINUTES);//一分钟过后过期
    }

    public String getDataFromRedis(String key){
        ValueOperations<String,String> ops = this.stringRedisTemplate.opsForValue();
        return ops.get(key);
    }

}
