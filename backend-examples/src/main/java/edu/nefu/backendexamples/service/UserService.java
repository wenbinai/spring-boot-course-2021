package edu.nefu.backendexamples.service;

import edu.nefu.backendexamples.entity.Student;
import edu.nefu.backendexamples.entity.User;
import edu.nefu.backendexamples.mapper.StudentMapper;
import edu.nefu.backendexamples.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> listStudents() {
        return studentMapper.list();
    }

    public User getUser(String number) {
        return userMapper.getByNumber(number);
    }
}
