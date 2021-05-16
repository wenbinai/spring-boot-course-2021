package edu.nefu.miaoshademo.vo;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
    private int code;
    private String msg;
    private Map<String, Object> data;

    public static ResultVO success(Map<String, Object> data) {
        return ResultVO.builder()
                .data(data)
                .code(200)
                .build();
    }

    public static ResultVO fail(int code, String msg) {
        return ResultVO.builder()
                .code(code)
                .msg(msg)
                .build();
    }
}
