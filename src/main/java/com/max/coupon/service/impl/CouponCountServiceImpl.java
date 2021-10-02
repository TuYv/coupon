package com.max.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    /**
     * 减库存操作
     */
    @Override
    public boolean minusStock(int id, int amount){
        UpdateWrapper<CouponCount> wrapper = new UpdateWrapper<>();
        //减去使用的库存
        wrapper.setSql("amount = amount - " + amount);
        wrapper.eq("id", id);
        //防止库存减为负数
        wrapper.ge("amount", amount);

        return update(wrapper);
    }
}
