package edu.nefu.mybatisdemo.example05;

import edu.nefu.mybatisdemo.entity.User;
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

    /**
     * 注意: 需要将受检异常转抛为RuntimeException才能触发事务回滚
     *
     * @param user
     */
    public void addUser(User user) {
        userMapper05.insert(user);
        try {
            Files.readString(Path.of("A/aa.aa"));
        } catch (IOException e) {
            throw new RuntimeException("操作错误");
        }
    }

}
