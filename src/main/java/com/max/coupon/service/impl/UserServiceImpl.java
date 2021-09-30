package com.max.com.max.mapper.service.impl;

import com.max.com.max.mapper.entity.User;
import com.max.com.max.mapper.mapper.UserMapper;
import com.max.com.max.mapper.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author max.tu
 * @since 2021-09-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
