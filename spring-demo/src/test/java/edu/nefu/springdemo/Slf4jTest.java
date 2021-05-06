package edu.nefu.springdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class Slf4jTest {
    @Test
    public void slf4jTest() {
        log.debug("slf4jTest");
        log.debug(log.getClass().getName());
    }

    @Test
    public void slf4jTest01() {
        // 测试占位符的使用
        var msg = "用户";
        if (2 > 1) {
            msg = "管理员";
        }
        log.debug("当前权限是: {}", msg);
    }
}
