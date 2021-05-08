package edu.nefu.backendexamples.common;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException {
    private int code;

    public MyException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
