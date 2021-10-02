package com.max.coupon.strategy;

import com.max.coupon.entity.CouponCount;
import com.max.coupon.entity.CouponUse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 优惠券生成工厂
 * @program: coupon
 * @description:
 * @author: Max.Tu
 * @create: 2021-10-01 11:49
 **/
public class CouponUseFactory {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 生成固定条优惠券
     * @return
     */
    public static List<CouponUse> getListCoupon(Integer userId, CouponCount couponCount, int num) {
        while (num-- > 0) {
            
        }
    }

    /**
     * 固定时间类型的优惠券新建方法
     * @param userId
     * @param couponCount
     * @return
     */
    public static CouponUse TimedCouponUse(Integer userId, CouponCount couponCount) {
        CouponUse couponUse = new CouponUse();
        couponUse.setUserId(userId);
        couponUse.setCouponCountId(couponCount.getId());
        //判断是什么类型的优惠券
        if (null == couponCount.getExpiryDate()) {
            couponUse.setStartTime(couponCount.getStartTime());
            couponUse.setEndTime(couponCount.getEndTime());
        } else {
            couponUse.setStartTime(LocalDateTime.now().format(formatter));
            couponUse.setEndTime(LocalDateTime.now().plusDays(couponCount.getExpiryDate()).format(formatter));
        }
        couponUse.setStatus(0);

        return couponUse;
    }

    /**
     * 有效期类型的优惠券新建方法
     * @param userId
     * @param couponCount
     * @return
     */
    public static CouponUse ValidCouponUse(Integer userId, CouponCount couponCount) {
        CouponUse couponUse = new CouponUse();
        couponUse.setUserId(userId);
        couponUse.setCouponCountId(couponCount.getId());
        //判断是什么类型的优惠券
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (null == couponCount.getExpiryDate()) {
            couponUse.setStartTime(couponCount.getStartTime());
            couponUse.setEndTime(couponCount.getEndTime());
        } else {
            couponUse.setStartTime(LocalDateTime.now().format(formatter));
            couponUse.setEndTime(LocalDateTime.now().plusDays(couponCount.getExpiryDate()).format(formatter));
        }
        couponUse.setStatus(0);

        return couponUse;
    }
}
