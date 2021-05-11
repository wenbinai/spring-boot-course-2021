package edu.nefu.backendexamples.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StudentTeacherServiceTest {

    @Autowired
    private StudentTeacherService studentTeacherService;
    long[] uids = new long[]{1392075101499400194L,
            1392075102090797058L,
            1392075102417952769L,
            1392075102728331265L,
            1392076586379485186L,
            1392076586710835201L,
            1392076587113488386L,
            1392076587449032706L,
            1392076587717468162L,
            1392076588187230209L,
            1392076588455665666L,
            1392076588791209986L,
            1392076589193863170L};

    long tid = 1391075388356579329L;


    @Test
    void chooseTeacher_test() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        int count = 13;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            int finalI = i;
            service.execute(() -> {
                try {
                    Thread.sleep(1000);
                    int num = studentTeacherService.chooseTeacher(uids[finalI], tid);
                    log.debug("执行结果: i: {}, count: {}", finalI, num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
        service.shutdown();
    }
}