package edu.nefu.backendexamples.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nefu.backendexamples.dto.TeacherDTO;
import edu.nefu.backendexamples.entity.StudentTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentTeacherMapper extends BaseMapper<StudentTeacher> {
    TeacherDTO getTeacher(long sid);


}