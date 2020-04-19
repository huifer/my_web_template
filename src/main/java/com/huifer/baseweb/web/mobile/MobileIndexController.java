package com.huifer.baseweb.web.mobile;

import com.huifer.baseweb.model.req.DemoReq;
import com.huifer.baseweb.model.res.UserInfoRes;
import com.huifer.baseweb.model.vo.ResultVO;
import com.huifer.baseweb.service.demo.IDemoBusinessService;
import com.huifer.baseweb.utils.ThreadLocalHelper;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobile/index")
public class MobileIndexController {

  @Autowired
  @Qualifier("demoService")
  IDemoBusinessService demoService;

  @PostMapping("/go")
  public void hh(@Validated @RequestBody DemoReq req) {

  }

  @GetMapping("/hh")
  public ResultVO test() {
    return ResultVO.success(ThreadLocalHelper.getDept().intValue());
  }

  @GetMapping("/null_test")
  public Object nullTest() {
    HashMap<String, Object> hh = new HashMap<>(16);

    hh.put("abc", null);
    hh.put("bbb", null);
    return hh;
  }

  @GetMapping("/h1")
  public UserInfoRes h1() {
    UserInfoRes userInfoRes = new UserInfoRes();
    return userInfoRes;
  }

  @GetMapping("d1")
  public void d1() {
    demoService.add();
  }

  @GetMapping("d2")
  public void d2() {
    demoService.up();
  }

}
