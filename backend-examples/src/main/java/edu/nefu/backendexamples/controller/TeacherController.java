package edu.nefu.backendexamples.controller;

import edu.nefu.backendexamples.dto.CourseDTO;
import edu.nefu.backendexamples.entity.Course;
import edu.nefu.backendexamples.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "处理教师角色请求", tags = {"Authorization, Teacher"})
@RestController
@RequestMapping("/api/teacher/")
public class TeacherController {

    @ApiOperation("添加课程，并返回当前教师全部课程")
    @PostMapping("courses")
    public ResultVO addCourse(@RequestBody Course course,
                              @RequestAttribute("uid") long uid) {
        return null;
    }

    @ApiOperation("获取当前教师全部课程")
    @GetMapping("courses")
    public ResultVO getCourses(@RequestAttribute("uid") long uid) {
        return null;
    }

    @ApiOperation(value = "为指定课程添加学生",
            notes = "学生不存在, 创建学生用户关联课程, 学生已存在, 直接关联课程")
    @PostMapping("students")
    public ResultVO addStudents(@RequestBody CourseDTO courseDTO,
                                @RequestAttribute("uid") long uid) {
        return null;
    }
}
