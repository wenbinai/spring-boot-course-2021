package edu.nefu.mybatisdemo.mapper;

import edu.nefu.mybatisdemo.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressMapperTest {
    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void addAddress_test() {
        Address address = Address.builder()
                .detail("nefu")
                .userId(1L)
                .build();
        addressMapper.insert(address);
    }
}