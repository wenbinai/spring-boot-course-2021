package edu.nefu.backendexamples.service;

import edu.nefu.backendexamples.dto.TeacherDTO;
import edu.nefu.backendexamples.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public List<TeacherDTO> list() {
        return teacherMapper.list();
    }
}
