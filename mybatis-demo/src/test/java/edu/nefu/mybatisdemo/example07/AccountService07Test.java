package edu.nefu.mybatisdemo.example07;

import edu.nefu.mybatisdemo.entity.Account;
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
class AccountService07Test {
    @Autowired
    private AccountService07 accountService07;

    @Test
    void buy_test() throws InterruptedException {
        // 创建线程池, 统一管理并发线程
        ExecutorService service = Executors.newCachedThreadPool();
        // 预计并发数量
        int count = 2;
        // 并发计数器, 用于阻塞测试线程
        // 否则, 创建并发子线程没有执行完毕, 测试线程就结束了
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            service.execute(() -> {
                try {
                    Thread.sleep(1000);
                    Account a = accountService07.buy(1, 600);
                    log.debug(a.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 减少计数器
                    latch.countDown();
                }
            });
        }
        // 阻塞线程, 当内部计数器为0时, 线程继续
        latch.await();
        // 关闭线程池
        service.shutdown();
    }

    @Test
    public void reduceOne_test() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        int count = 100;
        CountDownLatch latch = new CountDownLatch(count);
        service.execute(() -> {
            for (int i = 0; i < count; i++) {
                try {
                    Thread.sleep(100);
                    Account account = accountService07.reduceOne(1);
                    log.debug("余额: {}", account.getBalance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        });
        latch.await();
        service.shutdown();
    }
}