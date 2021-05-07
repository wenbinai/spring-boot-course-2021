package edu.nefu.springmvcdemo.exception;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyExcepiton extends RuntimeException {
    private int code;

    public MyExcepiton(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
