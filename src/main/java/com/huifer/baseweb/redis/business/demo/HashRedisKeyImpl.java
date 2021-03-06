package com.huifer.baseweb.redis.business.demo;

import com.huifer.baseweb.model.db.TDemo;
import com.huifer.baseweb.redis.IRedisCrudService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HashRedisKeyImpl implements IRedisCrudService<TDemo> {

  public static final String RK = "R_HASH:";

  @Autowired
  private RedisTemplate<String, TDemo> redisTemplate;

  @Override
  public void add(TDemo tDemo) {
    redisTemplate.opsForHash().put(RK, tDemo.getId().toString(), tDemo);
  }

  @Override
  public List<TDemo> queryAll() {
    List<TDemo> res = new ArrayList<>();
    List<Object> values = redisTemplate.opsForHash().values(RK);
    for (Object value : values) {
      if (value instanceof TDemo) {
        res.add((TDemo) value);
      }
    }
    return res;
  }

  @Override
  public void delete(TDemo tDemo) {
    Set<Object> keys = redisTemplate.opsForHash().keys(RK);
    for (Object key : keys) {
      if (key.equals(tDemo.getId().toString())) {
        redisTemplate.opsForHash().delete(RK, key);
      }
    }
  }
}
