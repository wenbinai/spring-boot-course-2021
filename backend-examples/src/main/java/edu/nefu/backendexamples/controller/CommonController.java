package edu.nefu.backendexamples.controller;

import edu.nefu.backendexamples.common.Role;
import edu.nefu.backendexamples.dto.TeacherDTO;
import edu.nefu.backendexamples.entity.Course;
import edu.nefu.backendexamples.service.*;
import edu.nefu.backendexamples.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "处理用户通用操作请求", tags = "Authorization")
@RestController
@RequestMapping("/api/common/")
public class CommonController {
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherCountService teacherCountService;
    @Autowired
    private StudentTeacherService studentTeacherService;
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("列出所有教师")
    @GetMapping("teachers")
    public ResultVO listTeachers() {
        List<TeacherDTO> teachers = teacherService.list();
        return ResultVO.success(Map.of("teachers", teachers));
    }

    @ApiOperation("学生选择教师")
    @PostMapping("graduation/teacher/{tid}")
    public ResultVO chooseTeacher(@PathVariable("tid") long tid,
                                  @RequestAttribute("uid") long uid) {
        int count = studentTeacherService.chooseTeacher(uid, tid);
        return ResultVO.success(Map.of("count", count));
    }

    @ApiOperation("学生查看自己选择的教师")
    @GetMapping("graduation/teacher")
    public ResultVO getTeacher(@RequestAttribute("uid") long uid) {
        TeacherDTO teacher = studentTeacherService.getTeacher(uid);
        return ResultVO.success(Map.of("teacher", teacher));
    }

    @ApiOperation("查看教师带的学生数量")
    @GetMapping("{teacherId}/count")
    public ResultVO getCount(@PathVariable("teacherId") long teacherId) {
        int count = teacherCountService.getCountById(teacherId);
        return ResultVO.success(Map.of("count", count));
    }

    @ApiOperation("登陆后首页信息, 加载用户全部信息")
    @GetMapping("home")
    public ResultVO getCourses(@RequestAttribute("uid") long uid,
                               @RequestAttribute("role") int role) {
        List<Course> courses = role == Role.TEACHER
                ? courseService.listCourseByTid(uid)
                : courseService.listCourseBySid(uid);
        return ResultVO.success(Map.of("courses", courses));
    }

    @ApiOperation("修改密码")
    @PatchMapping("password")
    public ResultVO patchPassword(@RequestBody Map<String, String> map,
                                  @RequestAttribute("uid") long uid) {
        userService.updatePassword(uid, map.get("password"));
        return ResultVO.success(Map.of());
    }
}
