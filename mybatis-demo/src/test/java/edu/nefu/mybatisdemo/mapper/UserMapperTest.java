package edu.nefu.mybatisdemo.mapper;

import edu.nefu.mybatisdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void update_test() {
        User u = User.builder()
                .id(1390222092205088770L)
                .company("nike")
                .build();
        userMapper.updateById(u);
    }
}