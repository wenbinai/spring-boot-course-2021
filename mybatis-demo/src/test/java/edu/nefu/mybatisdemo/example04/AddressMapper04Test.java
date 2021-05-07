package edu.nefu.mybatisdemo.example04;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AddressMapper04Test {
    @Autowired
    private AddressMapper04 addressMapper04;

    @Test
    void list_test() {
        List<AddressDTO04> addressDTOs = addressMapper04.list("林大");
        for (AddressDTO04 addressDTO : addressDTOs) {
            log.debug("addressDTO: {}", addressDTO.toString());
        }
    }

    @Test
    void list2_test() {
        List<AddressDTO04> addressDTOs = addressMapper04.list2("林大");
        for (AddressDTO04 addressDTO : addressDTOs) {
            log.debug("addressDTO: {}", addressDTO.toString());
        }
    }
}