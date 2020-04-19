package com.huifer.baseweb.service.login;

import com.huifer.baseweb.service.IBusinessService;

public interface ILoginService extends IBusinessService {

  @Override
  default String info() {
    return "登录服务";
  }
}
