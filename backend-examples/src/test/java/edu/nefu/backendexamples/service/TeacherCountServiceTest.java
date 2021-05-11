package edu.nefu.backendexamples.service;

import edu.nefu.backendexamples.entity.TeacherCount;
import edu.nefu.backendexamples.mapper.TeacherCountMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class TeacherCountServiceTest {
    @Autowired
    private TeacherCountService teacherCountService;
    @Autowired
    private TeacherCountMapper teacherCountMapper;

    final long id = 1391075388356579329L;

    @Test
    void updateCount() {
        int count = teacherCountService.getCountById(id);
        log.debug("count: {}", count);
        TeacherCount tc = TeacherCount.builder()
                .id(id)
                .count(count - 1)
                .build();
        teacherCountService.updateCount(tc);
        int updateCount = teacherCountService.getCountById(id);
        log.debug("updateCount: {}", updateCount);

    }

    @Test
    void updateCountByMapper() {
        TeacherCount teacherCount = teacherCountService.selectById(id);
        int count = teacherCount.getCount();
        log.debug("count: {}", count);
        teacherCount.setCount(count + 5);
        teacherCountMapper.updateById(teacherCount);
        int updateCount = teacherCount.getCount();
        log.debug("updateCount: {}", updateCount);

    }
}