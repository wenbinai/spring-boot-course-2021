package edu.nefu.miaoshademo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nefu.miaoshademo.entity.StockOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StockOrderMapper extends BaseMapper<StockOrder> {
}