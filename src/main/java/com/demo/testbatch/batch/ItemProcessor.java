package com.demo.testbatch.batch;

public interface ItemProcessor <I,O>{

    O process(I item);
}
