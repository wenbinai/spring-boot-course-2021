package edu.nefu.miaoshademo.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@TableName("stock_order")
public class StockOrder {
    private Integer id;

    private Integer sid;

    private String name;

    @TableField(updateStrategy = FieldStrategy.NEVER)
    private LocalDateTime createTime;
}