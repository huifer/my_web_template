package com.huifer.baseweb.ws.demo;

import com.huifer.baseweb.model.message.ColMessage;
import com.huifer.baseweb.ws.AbsWebSocket;
import com.huifer.baseweb.ws.IWebSocketService;
import java.io.IOException;
import javax.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ServerEndpoint("/demoWebSocket/{userId}")
public class DemoWebSocketService extends AbsWebSocket implements IWebSocketService<ColMessage> {

  @Override
  public void sendMessage(String s) throws IOException {

    super.getSession().getBasicRemote().sendText(s);
  }

  @Override
  public void send(String userId, ColMessage colMessage) throws IOException {
    log.info("发送消息到:" + userId + "，报文:" + colMessage.toSendMessage());
    if (StringUtils.isNotBlank(userId) && getWebSocketMap().containsKey(userId)) {
      getWebSocketMap().get(userId).sendMessage(colMessage.toSendMessage());
    } else {
      log.error("用户" + userId + ",不在线！");
    }
  }

  @Override
  public void sendMessage(ColMessage colMessage) throws IOException {
    super.getSession().getBasicRemote().sendText(colMessage.toSendMessage());
  }
}
