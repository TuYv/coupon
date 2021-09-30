package com.max.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.max.coupon.entity.Activity;
import com.max.coupon.mapper.ActivityMapper;
import com.max.coupon.service.IActivityService;
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
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements
    IActivityService {

}
