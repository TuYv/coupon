package com.max.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.max.coupon.entity.CouponCount;
import com.max.coupon.entity.CouponUse;
import com.max.coupon.mapper.CouponUseMapper;
import com.max.coupon.service.ICouponCountService;
import com.max.coupon.service.ICouponUseService;
import com.max.coupon.strategy.CouponUseFactory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author max.tu
 * @since 2021-09-30
 */
@Service
public class CouponUseServiceImpl extends ServiceImpl<CouponUseMapper, CouponUse> implements
    ICouponUseService {

    @Autowired
    CouponUseMapper couponUseMapper;
    @Autowired
    ICouponCountService couponCountService;

    @Override
    @Transactional
    public String getCoupon(CouponCount couponCount, int userId,int num) {

        //2.判断是否已经到达领取上限
        int count = selectCount(userId,couponCount.getId());
        if (count + num > couponCount.getCountLimit()) {
            return "领取已达上限，不可领取";
        } else {
            //如果库存足够 先减库存
            if(!couponCountService.minusStock(couponCount.getId(),num)) {
                return "库存不足，领取失败";
            }

            //增加优惠券
            List<CouponUse> list = CouponUseFactory.getListCoupon(userId,couponCount,num);
            boolean result = saveBatch(list);

            return result ? "领取成功" : "领取失败";
        }
    }

    public int selectCount(int userId,int couponId) {
        QueryWrapper<CouponUse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("coupon_count_id", couponId);

        return couponUseMapper.selectCount(queryWrapper);
    }

}
