package edu.nefu.mybatisdemo.example02;

import edu.nefu.mybatisdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapper02Test {
    @Autowired
    UserMapper02 userMapper02;

    @Test
    public void addUser_test() {
        User user = new User();
        user.setName("SUN");
        user.setCompany("amazon");
        userMapper02.insert(user);
    }

}