package tacos.web;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tacos.messaging.OrderMessagingService;
import tacos.model.TacoOrder;
import tacos.repository.OrderRepository;

@RestController
@Profile("jms|rabbit")
@RequestMapping(path="/api/orders", produces="application/json")
@CrossOrigin(origins="http://localhost:8080")
public class OrderApiController {
    private OrderRepository repo;
    private OrderMessagingService messageService;

    public OrderApiController(
            OrderRepository repo,
            OrderMessagingService messageService) {
        this.repo = repo;
        this.messageService = messageService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TacoOrder postOrder(@RequestBody TacoOrder order) {
        messageService.sendOrder(order);
        return repo.save(order);
    }
}
