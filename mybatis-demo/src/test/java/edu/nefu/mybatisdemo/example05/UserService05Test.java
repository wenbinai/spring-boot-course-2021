package edu.nefu.mybatisdemo.example05;

import edu.nefu.mybatisdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserService05Test {
    @Autowired
    private UserService05 userService05;

    @Test
    void addUser_test() {
        User u = User.builder()
                .name("aiwenbin")
                .build();
        userService05.addUser(u);
    }
}