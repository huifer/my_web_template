package com.huifer.baseweb.service.enums.impl;

import com.huifer.baseweb.mapper.TDemoMapper;
import com.huifer.baseweb.model.db.TDemo;
import com.huifer.baseweb.model.enums.SexEnums;
import com.huifer.baseweb.service.enums.IEnumsQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("enumsQueryService")
public class IEnumsQueryServiceImpl implements IEnumsQueryService {

  @Autowired
  private TDemoMapper tDemoMapper;

  @Override
  public TDemo query() {
    return tDemoMapper.queryEnums(SexEnums.MAN);
  }

}
