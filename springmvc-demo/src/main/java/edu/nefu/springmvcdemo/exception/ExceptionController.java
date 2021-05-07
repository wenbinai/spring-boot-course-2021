package edu.nefu.springmvcdemo.exception;

import edu.nefu.springmvcdemo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MyExcepiton.class)
    public ResultVO handlerValidException(MyExcepiton excepiton) {
        return ResultVO.error(excepiton.getCode(), excepiton.getMessage());
    }
}
