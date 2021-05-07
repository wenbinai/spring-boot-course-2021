package edu.nefu.mybatisdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nefu.mybatisdemo.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}