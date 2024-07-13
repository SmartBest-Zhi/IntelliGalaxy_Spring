package cn.yczbest.usercenterserver.controller;

import cn.yczbest.galaxy.common.BaseResponse;
import cn.yczbest.usercenterserver.entity.User;
import cn.yczbest.usercenterserver.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author SmartBest_Zhi
 * @since 2024-07-13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    public BaseResponse getUserList(@RequestBody Page<User> param) {
        return BaseResponse.Success(userService.list(param));
    }


}
