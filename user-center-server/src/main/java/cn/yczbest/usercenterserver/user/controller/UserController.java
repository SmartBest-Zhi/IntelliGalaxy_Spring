package cn.yczbest.usercenterserver.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "用户信息管理")
public class UserController {

    @GetMapping("/get")
    @ResponseBody
    @Operation(summary = "获取")
    public String get(String user) {
        return "Hello World";
    }

}
