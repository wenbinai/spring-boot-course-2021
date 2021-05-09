package edu.nefu.backendexamples.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nefu.backendexamples.entity.StudentCourse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentCourseMapper extends BaseMapper<StudentCourse> {
    default StudentCourse getStudentCourse(Long sid, Long cid) {
        return selectOne(new LambdaQueryWrapper<StudentCourse>()
                .eq(StudentCourse::getCourseId, cid)
                .eq(StudentCourse::getStudentId, sid));
    }
}