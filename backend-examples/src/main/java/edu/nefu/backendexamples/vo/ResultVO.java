package edu.nefu.backendexamples.vo;

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
                .code(200)
                .data(data)
                .build();
    }

    public static ResultVO error(int code, String msg) {
        return ResultVO.builder()
                .code(code)
                .msg(msg)
                .build();
    }
}
