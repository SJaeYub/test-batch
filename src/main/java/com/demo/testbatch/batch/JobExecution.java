package com.demo.testbatch.batch;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class JobExecution {
    private BatchStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
