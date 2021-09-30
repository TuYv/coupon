package com.max.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.max.coupon.entity.CouponCount;
import com.max.coupon.mapper.CouponCountMapper;
import com.max.coupon.service.ICouponCountService;
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
public class CouponCountServiceImpl extends ServiceImpl<CouponCountMapper, CouponCount> implements
    ICouponCountService {

}
