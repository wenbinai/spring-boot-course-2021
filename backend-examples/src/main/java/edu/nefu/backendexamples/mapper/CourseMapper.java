package edu.nefu.backendexamples.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nefu.backendexamples.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    default List<Course> listByTid(long tid) {
        return selectList(new LambdaQueryWrapper<Course>()
                .eq(Course::getTeacherId, tid));
    }

    List<Course> listBySid(long sid);

    default Course getCourse(long tid, Long cid) {
        return selectOne(new LambdaQueryWrapper<Course>()
                .eq(Course::getId, cid)
                .eq(Course::getTeacherId, tid));
    }
}