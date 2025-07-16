package cn.yczbest.usercenterserver.controller;

import cn.yczbest.galaxy.common.BaseResponse;
import cn.yczbest.usercenterserver.entity.User;
import cn.yczbest.usercenterserver.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @PostMapping("/register")
    public BaseResponse register(@RequestBody User param) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nick_name", param.getNickName());
        if (userService.count(queryWrapper) > 0){
            return BaseResponse.Error("用户已存在");
        }else{
            userService.save(param);
            return BaseResponse.Success("注册成功");
        }
    }

    @PostMapping("/delete")
    public BaseResponse delete(@RequestBody String nickName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nick_name", nickName);
        if (userService.count(queryWrapper) > 0){
            userService.remove(queryWrapper);
            return BaseResponse.Success("删除成功");
        }else{
            return BaseResponse.Error("用户不存在");
        }
    }

    @PostMapping("/update")
    public BaseResponse update(@RequestBody User param) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nick_name", param.getNickName());
        if (userService.count(queryWrapper) > 0){
            userService.update(queryWrapper);
            return BaseResponse.Success("修改成功");
        }else{
            return BaseResponse.Error("用户不存在");
        }
    }

    /**
     * 获取单个用户信息（注意是Get请求，并且注解变了）
     * @param nickName
     * @return
     */
    @PostMapping("/info")
    public BaseResponse info(@RequestParam String nickName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nick_name", nickName);
        User user = userService.getOne(queryWrapper);
        if (user != null){
            return BaseResponse.Success(user);
        }else{
            return BaseResponse.Error("用户不存在");
        }
    }

}
