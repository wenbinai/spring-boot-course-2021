package edu.nefu.mybatisdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nefu.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}