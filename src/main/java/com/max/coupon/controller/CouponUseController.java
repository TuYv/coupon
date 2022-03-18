package com.max.coupon.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.max.coupon.entity.CouponCount;
import com.max.coupon.entity.CouponUse;
import com.max.coupon.service.ICouponCountService;
import com.max.coupon.service.ICouponUseService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author max.tu
 * @since 2021-09-30
 */
@RestController
@RequestMapping("/coupon/use")
public class CouponUseController {

    @Autowired
    ICouponUseService couponUseService;
    @Autowired
    ICouponCountService couponCountService;

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(@RequestBody CouponUse couponUse) {
        boolean result = couponUseService.save(couponUse);
        return result ? "新增成功" : "新增失败";
    }

    /**
     * 模拟用户点击领取优惠券的操作
     * @param userId
     * @param couponId
     * @return
     */
    @RequestMapping(value = "getCoupon", method = RequestMethod.GET)
    public String getCoupon(@RequestParam("userId")int userId, @RequestParam("couponId")int couponId, @RequestParam("num")int num) {
        //1. 获取couponCount情况
        CouponCount couponCount = couponCountService.getById(couponId);

        return couponUseService.getCoupon(couponCount,userId, num);
    }
}
