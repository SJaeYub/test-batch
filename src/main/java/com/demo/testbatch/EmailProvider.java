package com.demo.testbatch;

import lombok.extern.slf4j.Slf4j;

public interface EmailProvider {

    void send(String emailAdress, String title, String body);

    @Slf4j
    class Fake implements EmailProvider {
        @Override
        public void send(String emailAdress, String title, String body) {
            log.info("{} ㅇㅣ메일 전송 완료 {} : {}", emailAdress, title, body);
        }
    }
}
