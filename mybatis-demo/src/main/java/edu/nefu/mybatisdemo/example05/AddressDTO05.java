package edu.nefu.mybatisdemo.example05;

import edu.nefu.mybatisdemo.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddressDTO05 {
    private Long id;
    private String detail;
    private User user;
    private LocalDateTime createTime;
}
