package edu.nefu.springmvcdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@Slf4j
public class PasswordEncoderTest {
    @Test
    public void encoder_test() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "123456";
        log.debug(passwordEncoder.encode(password));
        log.debug(passwordEncoder.encode(password));
        log.debug(passwordEncoder.encode("123456"));
    }
}
