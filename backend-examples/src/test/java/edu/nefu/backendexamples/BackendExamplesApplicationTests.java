package edu.nefu.backendexamples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendExamplesApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void parseIntWithNUll() {
        int i = Integer.parseInt(null);
        System.out.println(i);
    }

}
