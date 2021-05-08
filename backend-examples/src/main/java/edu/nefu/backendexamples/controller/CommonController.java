package edu.nefu.backendexamples.controller;

import edu.nefu.backendexamples.service.UserService;
import edu.nefu.backendexamples.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "处理用户通用操作请求", tags = "Authorization")
@RestController
@RequestMapping("/api/common/")
public class CommonController {
    @Autowired
    private UserService userService;

    @ApiOperation("修改密码")
    @PatchMapping("password")
    public ResultVO patchPassword(@RequestBody Map<String, String> map,
                                  @RequestAttribute("uid") long uid) {
        userService.updatePassword(uid, map.get("password"));
        return ResultVO.success(Map.of());
    }
}
