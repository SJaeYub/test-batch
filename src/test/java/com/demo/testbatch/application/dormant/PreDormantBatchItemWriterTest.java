package com.demo.testbatch.application.dormant;

import com.demo.testbatch.EmailProvider;
import com.demo.testbatch.customer.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PreDormantBatchItemWriterTest {

    private PreDormantBatchItemWriter preDormantBatchItemWriter;

    @Test
    @DisplayName("1주일 뒤에 휴면계정 전환 예정자라고 이메일을 전송해야한다.")
    void test1() {

        final EmailProvider mockEmailProvider = mock(EmailProvider.class);
        this.preDormantBatchItemWriter = new PreDormantBatchItemWriter(mockEmailProvider);

        final Customer customer = new Customer("jy", "test@test.net");

        preDormantBatchItemWriter.write(customer);

        verify(mockEmailProvider, atLeast(1)).send(any(), any(), any());
    }

}