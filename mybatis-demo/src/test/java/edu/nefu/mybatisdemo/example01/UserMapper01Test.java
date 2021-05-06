package edu.nefu.mybatisdemo.example01;

import edu.nefu.mybatisdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
@Slf4j
class UserMapper01Test {
    @Autowired
    private UserMapper01 userMapper01;

    @Test
    void insert_test() {
        User user = new User();
        user.setId(2L);
        user.setName("BO");
        user.setCompany("facebook");
        userMapper01.insert(user);
    }

    @Test
    void list_test() {
        for (User user : userMapper01.list()) {
            log.debug("{}/{}/{}", user.getName(),
                    user.getCompany(),
                    user.getCreateTime());
        }
    }

    @Test
    void get_test() {
        User user = userMapper01.get(1L);
        log.debug("{}/{}/{}", user.getName(),
                user.getCompany(),
                user.getUpdateTime());
    }
}