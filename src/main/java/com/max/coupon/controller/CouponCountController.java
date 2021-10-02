package com.max.coupon.controller;

import com.max.coupon.entity.CouponCount;
import com.max.coupon.entity.Redeem;
import com.max.coupon.service.ICouponCountService;
import com.max.coupon.service.IRedeemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/coupon/count")
public class CouponCountController {

    @Autowired
    ICouponCountService couponCountService;

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(@RequestBody CouponCount couponCount) {
        boolean result = couponCountService.save(couponCount);
        return result ? "新增成功" : "新增失败";
    }
}
