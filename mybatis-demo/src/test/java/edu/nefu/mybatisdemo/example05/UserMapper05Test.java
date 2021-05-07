package edu.nefu.mybatisdemo.example05;

import edu.nefu.mybatisdemo.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UserMapper05Test {
    @Autowired
    private UserMapper05 userMapper05;

    @Test
    public void getByIdXML_test() {
        UserDTO05 userDTO05 = userMapper05.getByIdXML(1L);
        log.debug("userDTO05: {}", userDTO05.toString());
        log.debug("{}/{}", userDTO05.getName(), userDTO05.getCompany());
        for (Address a : userDTO05.getAddresses()) {
            log.debug("{}/{}", a.getDetail(), a.getCreateTime());
        }
    }

    @Test
    public void getByXML_test() {
        UserDTO05 userDTO05 = userMapper05.getByXML(1L);
        log.debug("userDTO05: {}", userDTO05.toString());
        log.debug("{}/{}", userDTO05.getName(), userDTO05.getCompany());
        for (Address a : userDTO05.getAddresses()) {
            log.debug("{}/{}", a.getDetail(), a.getCreateTime());
        }
    }


}