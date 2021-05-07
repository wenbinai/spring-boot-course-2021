package edu.nefu.mybatisdemo.example05;

import edu.nefu.mybatisdemo.entity.User;
import edu.nefu.mybatisdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Transactional
public class UserService05 {
    @Autowired
    public UserMapper05 userMapper05;

    public void addUser(User user) {
        userMapper05.insert(user);
        try {
            Files.readString(Path.of("A/aa.aa"));
        } catch (IOException e) {
            throw new RuntimeException("操作错误");
        }
    }

}
