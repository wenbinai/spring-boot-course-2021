package edu.nefu.mybatisdemo.example03;

import edu.nefu.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper03 {
    @Select("select u.* from user u join address a " +
            "on u.id = a.user_id " +
            "where a.detail = #{detail}")
    List<User> listByDetail(String detail);
}
