package edu.nefu.backendexamples.service;

import edu.nefu.backendexamples.common.Role;
import edu.nefu.backendexamples.dto.StudentDTO;
import edu.nefu.backendexamples.dto.TeacherDTO;
import edu.nefu.backendexamples.entity.Student;
import edu.nefu.backendexamples.entity.StudentCourse;
import edu.nefu.backendexamples.entity.Teacher;
import edu.nefu.backendexamples.entity.User;
import edu.nefu.backendexamples.mapper.StudentCourseMapper;
import edu.nefu.backendexamples.mapper.StudentMapper;
import edu.nefu.backendexamples.mapper.TeacherMapper;
import edu.nefu.backendexamples.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentCourseMapper studentCourseMapper;
    @Autowired
    private PasswordEncoder encoder;

    public void updatePassword(long uid, String password) {
        userMapper.updateById(User.builder()
                .id(uid)
                .password(encoder.encode(password))
                .build());
    }

    public List<Student> listStudents() {
        return studentMapper.list();
    }

    public User getUser(String number) {
        return userMapper.getByNumber(number);
    }

    public Teacher addTeacher(TeacherDTO teacherDTO) {
        User u = User.builder()
                .name(teacherDTO.getName())
                .number(teacherDTO.getNumber())
                .password(encoder.encode(teacherDTO.getNumber()))
                .role(Role.TEACHER)
                .build();
        userMapper.insert(u);
        Teacher t = Teacher.builder()
                .id(u.getId())
                .title(teacherDTO.getTitle())
                .build();
        teacherMapper.insert(t);
        return t;
    }

    public void addStudents(List<StudentDTO> students, Long cid) {
        for (StudentDTO studentDTO : students) {
            studentDTO.setId(null);
            User u = userMapper.getByNumber(studentDTO.getNumber());
            // 学生存在
            if (u != null) {
                StudentCourse sc = studentCourseMapper.getStudentCourse(u.getId(), cid);
                // 学生已经和课程建立关系
                if (sc != null) {
                    continue;
                }
                // 学生存在, 但是没有和课程建立关系
                sc = StudentCourse.builder()
                        .studentId(u.getId())
                        .courseId(cid)
                        .build();
                studentCourseMapper.insert(sc);
                continue;
            }
            // 学生不存在
            u = User.builder()
                    .name(studentDTO.getName())
                    .role(Role.STUDENT)
                    .number(studentDTO.getNumber())
                    .password(encoder.encode(studentDTO.getNumber()))
                    .build();
            userMapper.insert(u);

            Student st = Student.builder()
                    .clazz(studentDTO.getClazz())
                    .id(u.getId())
                    .build();
            studentMapper.insert(st);

            StudentCourse sc = StudentCourse.builder()
                    .studentId(u.getId())
                    .courseId(cid)
                    .build();
            studentCourseMapper.insert(sc);

        }
    }

    /**
     * 批量导入学生
     *
     * @param students
     * @return
     */
    public List<Student> addStudents(List<StudentDTO> students) {
        List<Student> res = new ArrayList<>();
        for (StudentDTO studentDTO : students) {
            User u = User.builder()
                    .name(studentDTO.getName())
                    .role(Role.STUDENT)
                    .number(studentDTO.getNumber())
                    .password(encoder.encode(studentDTO.getNumber()))
                    .build();
            userMapper.insert(u);

            Student st = Student.builder()
                    .id(u.getId())
                    .clazz(studentDTO.getClazz())
                    .build();
            studentMapper.insert(st);
            res.add(st);
        }
        return res;
    }
}
