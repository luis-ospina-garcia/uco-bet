package co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog;

import co.edu.uco.ucobet.generales.application.secondaryports.messagecatalog.MessageCatalog;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageCatalogImpl implements MessageCatalog {

    private final RedisTemplate<String, String> redisTemplate;

    public MessageCatalogImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String getMessage(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public String getMessageOrDefault(String key) {
        String value = redisTemplate.opsForValue().get(key);
        return (value != null) ? value : "Mensaje predeterminado";
    }
}
