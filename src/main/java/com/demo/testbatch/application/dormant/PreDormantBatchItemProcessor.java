package com.demo.testbatch.application.dormant;

import com.demo.testbatch.batch.ItemProcessor;
import com.demo.testbatch.customer.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PreDormantBatchItemProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) {
        LocalDate targetDate = LocalDate.now()
                .minusDays(365)
                .plusDays(7);

        if(targetDate.equals(customer.getLoginAt().toLocalDate())) {
            return customer;
        } else {
            return null;
        }
    }
}
