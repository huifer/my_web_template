package com.huifer.baseweb.service.login.impl;

import com.huifer.baseweb.event.login.LoginEvent;
import com.huifer.baseweb.event.login.LoginEventListener;
import com.huifer.baseweb.factory.EventListenerFactoryInterface;
import com.huifer.baseweb.factory.impl.LoginEventListenerFactory;
import com.huifer.baseweb.model.enums.LoginTypeEnums;
import com.huifer.baseweb.model.req.UserLoginReq;
import com.huifer.baseweb.service.login.ILoginEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service("logEventService")
public class LogEventService implements ILoginEventService {

  @Autowired
  private ApplicationContext applicationContext;
  private LoginEventListener loginEventListener;

  @Override
  public void login(UserLoginReq userLoginReq) {
    EventListenerFactoryInterface<LoginEventListener, LoginTypeEnums> eventListenerFactoryInterface
        = new LoginEventListenerFactory(applicationContext);

    LoginTypeEnums loginTypeEnums = LoginTypeEnums
        .valueOf(userLoginReq.getLoginType().toUpperCase());
    loginEventListener = eventListenerFactoryInterface.newInstance(loginTypeEnums);
    if (this.loginEventListener != null) {
      this.loginEventListener
          .afterLogin(new LoginEvent(userLoginReq.getLoginType(), userLoginReq.getUserId()));
    }

  }


}
