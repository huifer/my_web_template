package com.huifer.baseweb.model.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum LoginTypeEnums {
  WX("WX"),
  QQ("QQ"),
  ;
  private String name;
}
