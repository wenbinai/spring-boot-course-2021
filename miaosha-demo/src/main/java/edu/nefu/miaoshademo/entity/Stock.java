package edu.nefu.miaoshademo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@TableName("stock")
public class Stock {
    private Integer id;

    private String name;

    private Integer count;

    private Integer sale;

    @Version
    private Integer version;
}