package edu.nefu.backendexamples.service;

import edu.nefu.backendexamples.entity.Course;
import edu.nefu.backendexamples.mapper.CourseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public List<Course> listCourseByTid(long uid) {
        return courseMapper.listByTid(uid);
    }

    public List<Course> listCourseBySid(long uid) {
        return courseMapper.listBySid(uid);
    }

    public Course getCourse(long tid, Long cid) {
        return courseMapper.getCourse(tid, cid);
    }

    public void addCourse(Course course, long uid) {
        course.setId(null);
        course.setTeacherId(uid);
        courseMapper.insert(course);
    }
}
