package cn.yczbest.usercenterserver.service.impl;

import cn.yczbest.usercenterserver.entity.User;
import cn.yczbest.usercenterserver.mapper.UserMapper;
import cn.yczbest.usercenterserver.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SmartBest_Zhi
 * @since 2024-07-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
