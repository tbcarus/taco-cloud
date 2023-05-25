package tacos.messaging.jms;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import tacos.messaging.OrderMessagingService;
import tacos.model.TacoOrder;

@Service
public class JmsOrderMessagingService implements OrderMessagingService {
    private JmsTemplate jms;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms) {
        this.jms = jms;
    }
    @Override
    public void sendOrder(TacoOrder order) {
//        jms.send("tacocloud.order.queue", session -> session.createObjectMessage(order));
        jms.convertAndSend("tacocloud.order.queue", order, message -> addOrderSource(message));
    }

    private Message addOrderSource(Message message) throws JMSException {
        message.setStringProperty("X_ORDER_SOURCE", "WEB");
        return message;
    }
}
