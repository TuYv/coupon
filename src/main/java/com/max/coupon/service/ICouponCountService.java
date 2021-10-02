package com.max.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.max.coupon.entity.CouponCount;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author max.tu
 * @since 2021-09-30
 */
public interface ICouponCountService extends IService<CouponCount> {

    boolean minusStock(int id, int amount);
}
