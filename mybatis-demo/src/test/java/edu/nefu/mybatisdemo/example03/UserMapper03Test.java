package edu.nefu.mybatisdemo.example03;

import edu.nefu.mybatisdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserMapper03Test {
    @Autowired
    private UserMapper03 userMapper03;

    @Test
    void listByDetail_test() {
        List<User> users = userMapper03.listByDetail("林大");
        for (User u : users) {
            log.debug("{}/{}/{}", u.getName()
                    , u.getCompany(), u.getCreateTime());
        }
    }
}