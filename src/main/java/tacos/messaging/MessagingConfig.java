package tacos.messaging;

import jakarta.jms.Destination;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import tacos.model.TacoOrder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MessagingConfig {

  @Bean
  @Profile("jms")
  public MappingJackson2MessageConverter messageConverterJms() {
    MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
    messageConverter.setTypeIdPropertyName("_typeId");

    Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
    typeIdMappings.put("order", TacoOrder.class);
    messageConverter.setTypeIdMappings(typeIdMappings);

    return messageConverter;
  }

  @Bean
  @Profile("jms")
  public Destination orderQueue() {
    return new ActiveMQQueue("tacocloud.order.queue");
  }

  @Bean
  @Profile("rabbit")
  public Jackson2JsonMessageConverter messageConverterRabbit() {
    return new Jackson2JsonMessageConverter();
  }

}
