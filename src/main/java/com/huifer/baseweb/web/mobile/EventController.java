package com.huifer.baseweb.web.mobile;

import com.huifer.baseweb.constants.InitializrGlobalValue;
import com.huifer.baseweb.model.req.UserLoginReq;
import com.huifer.baseweb.service.IInitializrService;
import com.huifer.baseweb.service.login.impl.LogEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

  @Autowired
  @Qualifier("logEventService")
  LogEventService logEventService;

  @Autowired
  IInitializrService initializrService;

  @PostMapping("/login")
  public void login(
      @RequestBody UserLoginReq userLoginReq
  ) {
    InitializrGlobalValue value = initializrService.getValue();
    logEventService.login(userLoginReq);
  }

}
