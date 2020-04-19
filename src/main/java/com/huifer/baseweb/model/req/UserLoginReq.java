package com.huifer.baseweb.model.req;

import lombok.Data;

@Data
public class UserLoginReq {

  private String loginType;
  private Integer userId;
}
