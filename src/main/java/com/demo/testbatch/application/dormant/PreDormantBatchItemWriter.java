package com.demo.testbatch.application.dormant;

import com.demo.testbatch.EmailProvider;
import com.demo.testbatch.batch.ItemWriter;
import com.demo.testbatch.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PreDormantBatchItemWriter implements ItemWriter<Customer> {

    private final EmailProvider emailProvider;

    @Autowired
    public PreDormantBatchItemWriter() {
        this.emailProvider = new EmailProvider.Fake();
    }

    public PreDormantBatchItemWriter(EmailProvider emailProvider) {
        this.emailProvider = emailProvider;
    }

    @Override
    public void write(Customer customer) {
        emailProvider.send(customer.getEmail(), "곧 휴면계정 전환됨", "body");
    }
}
