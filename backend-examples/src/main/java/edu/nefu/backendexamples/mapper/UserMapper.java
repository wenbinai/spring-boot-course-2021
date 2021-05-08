package edu.nefu.backendexamples.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nefu.backendexamples.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    default User getByNumber(String number) {
        return selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getNumber, number));
    }
}