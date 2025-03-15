package com.demo.testbatch.application.dormant;

import com.demo.testbatch.batch.ItemProcessor;
import com.demo.testbatch.customer.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DormantBatchItemProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer item) {
        boolean isDormantTarget = LocalDate.now().minusDays(365).isAfter(item.getLoginAt().toLocalDate());

        if(isDormantTarget){
            item.setStatus(Customer.Status.DORMANT);
            return item;
        } else {
            return null;
        }
    }
}
