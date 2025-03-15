package com.demo.testbatch.application.dormant;

import com.demo.testbatch.EmailProvider;
import com.demo.testbatch.batch.ItemWriter;
import com.demo.testbatch.customer.Customer;
import com.demo.testbatch.customer.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class DormantBatchItemWriter implements ItemWriter<Customer> {

    private final CustomerRepository customerRepository;
    private final EmailProvider emailProvider;

    public DormantBatchItemWriter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.emailProvider = new EmailProvider.Fake();
    }

    @Override
    public void write(Customer item) {
        customerRepository.save(item);
        emailProvider.send(item.getEmail(), "휴면전환 안내메일입니다.", "내용");
    }
}
