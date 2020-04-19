package com.huifer.baseweb.model.message;

import com.alibaba.fastjson.JSON;
import com.huifer.baseweb.base.WebSocketMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ColMessage implements WebSocketMessage {

  private String name;

  @Override
  public String toSendMessage() {
    return JSON.toJSONString(this);
  }
}
