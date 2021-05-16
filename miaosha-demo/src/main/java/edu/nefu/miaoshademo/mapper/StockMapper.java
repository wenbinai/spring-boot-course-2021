package edu.nefu.miaoshademo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nefu.miaoshademo.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StockMapper extends BaseMapper<Stock> {
}