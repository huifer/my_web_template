package com.huifer.baseweb.redis.business.demo;

import com.huifer.baseweb.model.db.TDemo;
import com.huifer.baseweb.redis.IRedisCrudService;
import java.util.Iterator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ListRedisKeyImpl implements IRedisCrudService<TDemo> {

  public static final String RK = "R_LIST:";

  @Autowired
  private RedisTemplate<String, TDemo> redisTemplate;


  @Override
  public void add(TDemo tDemo) {
    redisTemplate.opsForList().rightPush(RK, tDemo);
  }

  @Override
  public List<TDemo> queryAll() {
    return redisTemplate.opsForList().range(RK, 0, -1);
  }

  @Override
  public void update(TDemo tDemo) {
    // 放到本地
    List<TDemo> range = redisTemplate.opsForList().range(RK, 0, -1);
    // 全删除
    redisTemplate.delete(RK);
    // 循环插入
    Iterator<TDemo> iterator = range.iterator();
    while (iterator.hasNext()) {
      TDemo next = iterator.next();
      if (next.getId().equals(tDemo.getId())) {
        BeanUtils.copyProperties(tDemo, next);
        this.add(next);

      } else {
        this.add(next);

      }
    }
  }


  @Override
  public void delete(String key) {

  }
}
