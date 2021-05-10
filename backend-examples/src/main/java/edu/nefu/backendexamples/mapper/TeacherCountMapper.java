package edu.nefu.backendexamples.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nefu.backendexamples.entity.TeacherCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeacherCountMapper extends BaseMapper<TeacherCount> {
    default int getCountById(long teacherId) {
        return selectOne(new LambdaQueryWrapper<TeacherCount>()
                .eq(TeacherCount::getId, teacherId)).getCount();
    }
}