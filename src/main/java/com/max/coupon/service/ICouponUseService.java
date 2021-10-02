package com.max.coupon.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.max.coupon.entity.CouponUse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author max.tu
 * @since 2021-09-30
 */
public interface ICouponUseService extends IService<CouponUse> {

    int selectCount(QueryWrapper<CouponUse> queryWrapper);
}
