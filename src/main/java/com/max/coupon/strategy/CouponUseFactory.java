package com.max.coupon.strategy;

import com.max.coupon.entity.CouponCount;
import com.max.coupon.entity.CouponUse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
     * 生成一条优惠券
     * @param userId
     * @param couponCount
     * @return
     */
    public static CouponUse getCouponUse(int userId, CouponCount couponCount) {
        return getListCoupon(userId,couponCount,1).get(0);
    }

    /**
     * 生成固定条优惠券
     * @return
     */
    public static List<CouponUse> getListCoupon(Integer userId, CouponCount couponCount, int num) {
        List<CouponUse> result = new ArrayList<>();
        while (num-- > 0) {
            CouponUse couponUse;
            if (null == couponCount.getExpiryDate()) {
                couponUse = TimedCouponUse(userId,couponCount);
            } else {
                couponUse = ValidCouponUse(userId, couponCount);
            }
            result.add(couponUse);
        }
        return result;
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
        couponUse.setStartTime(couponCount.getStartTime());
        couponUse.setEndTime(couponCount.getEndTime());
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
        couponUse.setStartTime(LocalDateTime.now().format(formatter));
        couponUse.setEndTime(LocalDateTime.now().plusDays(couponCount.getExpiryDate()).format(formatter));
        couponUse.setStatus(0);

        return couponUse;
    }
}
