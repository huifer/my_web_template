package com.huifer.baseweb.model.req;


import com.huifer.baseweb.model.enums.SexEnums;
import com.huifer.baseweb.valid.EnumValidAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoReq {

  @EnumValidAnnotation(message = "枚举异常", target = SexEnums.class)
  private String target;

}
