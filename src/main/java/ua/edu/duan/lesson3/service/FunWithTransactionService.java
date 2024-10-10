package ua.edu.duan.lesson3.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.edu.duan.lesson3.entity.OrderEntity;
import ua.edu.duan.lesson3.repository.OrderCountRepository;
import ua.edu.duan.lesson3.repository.OrderRepository;

@Service
public class FunWithTransactionService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderCountRepository orderCountRepository;

    @Autowired
    private FunWithTransactionService funWithTransactionService;

    private PlatformTransactionManager platformTransactionManager;


    @PostConstruct
    public void init(){
        orderRepository.deleteAll();

        orderCountRepository.findById(1L).ifPresent(
                orderCountEntity -> {
                    orderCountEntity.setCount(0);
                    orderCountRepository.save(orderCountEntity);
                }
        );
    }



    @Transactional
    public void buy() {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setDescription("Order from customer in " + System.currentTimeMillis());
        orderRepository.save(orderEntity);

        System.out.println("SeEnd order to delivery company");

        funWithTransactionService.update_counter();
    }


    @Transactional(propagation = Propagation.MANDATORY)
    public void update_counter(){
        orderCountRepository.findByIdForUpdate(1L).ifPresent(
                orderCountEntity -> orderCountEntity.setCount(orderCountEntity.getCount() + 1));
    }
}
