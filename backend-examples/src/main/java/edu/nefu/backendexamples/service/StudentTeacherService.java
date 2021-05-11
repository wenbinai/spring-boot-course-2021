package edu.nefu.backendexamples.service;

import edu.nefu.backendexamples.common.MyException;
import edu.nefu.backendexamples.dto.TeacherDTO;
import edu.nefu.backendexamples.entity.StudentTeacher;
import edu.nefu.backendexamples.entity.TeacherCount;
import edu.nefu.backendexamples.mapper.StudentTeacherMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class StudentTeacherService {
    @Autowired
    private StudentTeacherMapper studentTeacherMapper;
    @Autowired
    private TeacherCountService teacherCountService;

    public TeacherDTO getTeacher(long uid) {
        return studentTeacherMapper.getTeacher(uid);
    }

    public int chooseTeacher(long uid, long tid) {
        // 查看教师还剩多少人
        TeacherCount teacherCount = teacherCountService.selectById(tid);
        int count = teacherCount.getCount();
        log.debug("start count: {}", count);
        if (count <= 0) {
            throw new MyException(401, "该教师指导学生数目已满, 不能选择, 请选择其他老师");
        }
        teacherCount.setCount(count - 1);
        int update = teacherCountService.updateCount(teacherCount);
        log.debug("update: {}", update);
        if (update <= 0) {
            throw new MyException(401, "该教师指导学生数目已满, 不能选择, 请选择其他老师");
        } else {
            // 更新选择表
            StudentTeacher st = StudentTeacher
                    .builder()
                    .studentId(uid)
                    .teacherId(tid)
                    .build();
            studentTeacherMapper.insert(st);
        }
        // 返回选择完后教师剩余的数量
        int resCount = teacherCountService.getCountById(tid);
        log.debug("end count: {}", resCount);
        return resCount;
    }
}
