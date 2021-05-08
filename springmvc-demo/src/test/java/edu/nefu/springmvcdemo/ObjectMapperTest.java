package edu.nefu.springmvcdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nefu.springmvcdemo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Slf4j
public class ObjectMapperTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void objectMapper_test() {
        User user = new User();
        user.setUserName("BO");
        user.setPassword("123456");
        try {
            String json = objectMapper.writeValueAsString(user);
            log.debug(json);
            User u = objectMapper.readValue(json, User.class);
            log.debug("{} / {}", u.getUserName(), u.getPassword());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试序列化泛型数据, 默认不支持序列化泛型数据
     */
    @Test
    public void objectMapper2_test() {
        User user = new User();
        user.setUserName("BO");
        user.setPassword("123456");
        Map<String, User> map = Map.of("user", user);
        try {
            String json = objectMapper.writeValueAsString(map);
            log.debug(json);
            Map<String, User> resMap = objectMapper.readValue(json, Map.class);
            resMap.forEach((k, v) -> {
                log.debug(k);
                log.debug((v.getUserName() + "/" + v.getPassword()));
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于TypeReference 反序列化具体化带泛型的数据
     */
    @Test
    public void objectMapper3_test() {
        User user = new User();
        user.setUserName("BO");
        user.setPassword("123456");
        Map<String, User> map = Map.of("user", user);
        try {
            String json = objectMapper.writeValueAsString(map);
            log.debug(json);
            Map<String, User> resMap = objectMapper.readValue(json, new TypeReference<Map<String, User>>() {
            });
            resMap.forEach((k, v) -> {
                log.debug(k);
                log.debug((v.getUserName() + "/" + v.getPassword()));
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
