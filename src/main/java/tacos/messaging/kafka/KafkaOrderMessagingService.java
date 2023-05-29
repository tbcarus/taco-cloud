package tacos.messaging.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tacos.messaging.OrderMessagingService;
import tacos.model.TacoOrder;

@Service
@Profile("kafka")
public class KafkaOrderMessagingService implements OrderMessagingService {

    private KafkaTemplate<String, TacoOrder> kafkaTemplate;

    @Autowired
    public KafkaOrderMessagingService(KafkaTemplate<String, TacoOrder> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendOrder(TacoOrder order) {
//        kafkaTemplate.send("tacocloud.orders.topic", order);
        kafkaTemplate.sendDefault(order);
    }

}
