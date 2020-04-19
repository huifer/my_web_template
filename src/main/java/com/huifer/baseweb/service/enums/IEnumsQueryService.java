package com.huifer.baseweb.service.enums;

import com.huifer.baseweb.model.db.TDemo;
import com.huifer.baseweb.service.IBusinessService;

public interface IEnumsQueryService extends IBusinessService {

  TDemo query();

  @Override
  default String info() {
    return "枚举查询";
  }
}
