package com.huifer.baseweb.service.login;

import com.huifer.baseweb.model.req.UserLoginReq;
import com.huifer.baseweb.service.IBusinessService;

public interface ILoginEventService extends IBusinessService {

  /**
   * 登陆事件
   * @param userLoginReq
   */
  void login(UserLoginReq userLoginReq);

  /**
   * 信息
   *
   * @return "业务接口标记"
   */
  @Override
  default String info() {
    return "登陆事件服务";
  }
}
