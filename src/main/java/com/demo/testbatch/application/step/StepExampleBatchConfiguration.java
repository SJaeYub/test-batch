package com.demo.testbatch.application.step;

import com.demo.testbatch.batch.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Configuration
public class StepExampleBatchConfiguration {

    @Bean
    public Job stepExampleBatchJob(Step step1, Step step2, Step step3) {
        return new StepJobBuilder()
                .start(step1)
                .next(step2)
                .next(step3)
                .build();
    }

    @Bean
    public Step step1() {
        final Tasklet tasklet = () -> System.out.println("Step 1");
        return new Step(tasklet);
    }

    @Bean
    public Step step2() {
        final Tasklet tasklet = () -> System.out.println("Step 2");
        return new Step(tasklet);
    }

    @Bean
    public Step step3() {
        final Tasklet tasklet = () -> System.out.println("Step 3");
        return new Step(tasklet);
    }
}
