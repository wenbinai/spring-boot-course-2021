package edu.nefu.backendexamples.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nefu.backendexamples.entity.Student;
import edu.nefu.backendexamples.entity.StudentCourse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    List<Student> list();
}