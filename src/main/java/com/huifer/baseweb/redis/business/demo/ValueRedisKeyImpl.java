package com.huifer.baseweb.redis.business.demo;

import com.huifer.baseweb.constants.BaseConstants.RedisKey;
import com.huifer.baseweb.model.db.TDemo;
import com.huifer.baseweb.redis.IRedisCrudService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ValueRedisKeyImpl implements IRedisCrudService<TDemo> {

  /**
   * 测试key
   */
  public static final String DEMO_REDIS_KEY = RedisKey.DEMO;


  @Autowired
  private RedisTemplate<String, TDemo> redisTemplate;

  @Override
  public void add(TDemo tDemo) {
    String key = DEMO_REDIS_KEY + UUID.randomUUID().toString();
    log.info("添加redis,key =[{}],value=[{}]", key, tDemo);
    redisTemplate.opsForValue().set(key, tDemo);
  }

  @Override
  public List<TDemo> queryAll() {
    Set<String> keys = redisTemplate.keys(DEMO_REDIS_KEY + "*");
    List<TDemo> tDemos = new ArrayList<>();

    assert keys != null;
    for (String key : keys) {
      TDemo tDemo = redisTemplate.opsForValue().get(key);
      tDemos.add(tDemo);
    }
    return tDemos;
  }

  @Override
  public void update(String key, TDemo tDemo) {
    if (log.isDebugEnabled()) {
      log.debug("开始更新,key=[{}],value=[{}]", key, tDemo);
    }
    Set<String> keys = redisTemplate.keys(DEMO_REDIS_KEY + "*");
    assert keys != null;
    if (!keys.isEmpty() && keys.contains(key)) {
      // 先删除
      redisTemplate.delete(key);
      // 再更新
      redisTemplate.opsForValue().set(key, tDemo);
    }

  }

  @Override
  public void delete(String key) {
    if (log.isDebugEnabled()) {
      log.debug("开始删除,key=[{}]", key);
    }
    Set<String> keys = redisTemplate.keys(DEMO_REDIS_KEY + "*");
    assert keys != null;
    if (!keys.isEmpty() && keys.contains(key)) {
      redisTemplate.delete(key);
    }

  }
}
