package edu.nefu.backendexamples.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nefu.backendexamples.dto.TeacherDTO;
import edu.nefu.backendexamples.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    List<TeacherDTO> list();
}