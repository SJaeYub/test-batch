package com.demo.testbatch.batch.generator;

import com.demo.testbatch.domain.ApiOrder;
import com.demo.testbatch.domain.ServicePolicy;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

@Component
public class ApiOrderGenerateProcessor implements ItemProcessor<Boolean, ApiOrder> {

    private final List<Long> customerIds = LongStream.range(0, 20).boxed().toList();
    private final List<ServicePolicy> servicePolicies = Arrays.stream(ServicePolicy.values()).toList();
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Override
    public ApiOrder process(Boolean item) throws Exception {

        final Long randomCustormerId = customerIds.get(random.nextInt(customerIds.size()));
        final ServicePolicy randomServicePolicy = servicePolicies.get(random.nextInt(servicePolicies.size()));

        final ApiOrder.State randomState = random.nextInt(5) % 5 == 1 ? ApiOrder.State.FAIL : ApiOrder.State.SUCCESS;

        return new ApiOrder(
                UUID.randomUUID().toString(),
                randomCustormerId,
                randomServicePolicy.getUrl(),
                randomState,
                LocalDateTime.now().format(formatter)
        );
    }
}
