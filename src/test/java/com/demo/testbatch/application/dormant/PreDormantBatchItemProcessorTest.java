package com.demo.testbatch.application.dormant;

import com.demo.testbatch.customer.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PreDormantBatchItemProcessorTest {

    private PreDormantBatchItemProcessor preDormantBatchItemProcessor;

    @BeforeEach
    void setUp() {
        preDormantBatchItemProcessor = new PreDormantBatchItemProcessor();
    }

    @Test
    @DisplayName("로그인 날짜가 오늘로부터 358일 전이면 customer를 반환해야한다")
    void test1() {
        final Customer customer = new Customer("jy", "jy@test.net");
        customer.setLoginAt(LocalDateTime.now().minusDays(365).plusDays(7));

        final Customer result = preDormantBatchItemProcessor.process(customer);

        Assertions.assertThat(result).isEqualTo(customer);
        Assertions.assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("로그인 날짜가 오늘로부터 358일 전이 아니면 null를 반환해야한다")
    void test2() {
        final Customer customer = new Customer("jy", "jy@test.net");
        final Customer result = preDormantBatchItemProcessor.process(customer);
        Assertions.assertThat(result).isNull();
    }
}