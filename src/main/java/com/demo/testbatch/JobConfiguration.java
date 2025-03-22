package com.demo.testbatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class JobConfiguration {

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("job-chunk", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
                .tasklet((a, b) -> {
                    log.info("step started");
                    return RepeatStatus.FINISHED;
                }, transactionManager)
                //step을 재시작하기 위해 아래 두 옵션이 들어가야함
                .allowStartIfComplete(true)
                .startLimit(5)
                .build();
    }

//    @Bean
//    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//
//        ItemReader<Integer> itemReader = new ItemReader<>() {
//
//            private int count = 0;
//
//            @Override
//            public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//                count++;
//
//                log.info("Read count: {}", count);
//
//                if (count == 15) {
//                    return null;
//                }
//
//                return count;
//            }
//        };
//
//        return new StepBuilder("step", jobRepository)
//                .chunk(10, transactionManager)
//                .reader(itemReader)
////                .processor()
//                .writer(read -> {})
//                .build();
//    }
}
