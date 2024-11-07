package co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageCatalogService {

    private final RedisTemplate<String, String> redisTemplate;

    
    public MessageCatalogService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    
    public String getMessage(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
