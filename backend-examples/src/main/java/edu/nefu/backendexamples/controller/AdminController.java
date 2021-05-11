package edu.nefu.backendexamples.controller;

import edu.nefu.backendexamples.dto.StudentDTO;
import edu.nefu.backendexamples.dto.TeacherDTO;
import edu.nefu.backendexamples.entity.Student;
import edu.nefu.backendexamples.entity.Teacher;
import edu.nefu.backendexamples.service.UserService;
import edu.nefu.backendexamples.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {
    @Autowired
    private UserService userService;

    @ApiOperation("初始化教师所带学生数量")
    @PostMapping("init/teacher/count")
    public ResultVO initTeacherCount() {
        return null;
    }

    @ApiOperation("添加教师")
    @PostMapping("teachers")
    public ResultVO addTeacher(@RequestBody TeacherDTO teacherDTO) {
        Teacher t = userService.addTeacher(teacherDTO);
        return ResultVO.success(Map.of("teacher", t));
    }

    @ApiOperation("添加学生")
    @PostMapping("students")
    public ResultVO addStudents(@RequestBody List<StudentDTO> students) {
        List<Student> students1 = userService.addStudents(students);
        return ResultVO.success(Map.of("students", students1));
    }

}
