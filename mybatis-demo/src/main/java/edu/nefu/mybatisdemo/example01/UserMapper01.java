package edu.nefu.mybatisdemo.example01;

import edu.nefu.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper01 {
    @Insert("insert into user(id, name, company) values (#{id}, #{name}, #{company})")
    void insert(User user);

    @Select("select * from user")
    List<User> list();

    @Select("select * from user u where u.id = #{aid}")
    User get(@Param("aid") long uid);
}
