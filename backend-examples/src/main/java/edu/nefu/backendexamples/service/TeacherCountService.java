package edu.nefu.backendexamples.service;

import edu.nefu.backendexamples.entity.TeacherCount;
import edu.nefu.backendexamples.mapper.TeacherCountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherCountService {
    @Autowired
    private TeacherCountMapper teacherCountMapper;

    public int getCountById(long teacherId) {
        return teacherCountMapper.getCountById(teacherId);
    }

    public int updateCount(TeacherCount teacherCount) {
        return teacherCountMapper.updateById(teacherCount);
    }
}
