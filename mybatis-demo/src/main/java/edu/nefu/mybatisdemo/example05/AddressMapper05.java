package edu.nefu.mybatisdemo.example05;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nefu.mybatisdemo.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper05 extends BaseMapper<Address> {

    List<AddressDTO05> listAddressDTOs(@Param("detail") String detail);
}
