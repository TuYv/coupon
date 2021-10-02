package com.max.coupon.controller;

import com.max.coupon.entity.CouponTemp;
import com.max.coupon.service.ICouponTempService;
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
@RequestMapping("/coupon/temp")
public class CouponTempController {

    @Autowired
    ICouponTempService couponTempService;

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(@RequestBody CouponTemp couponTemp) {
        boolean result = couponTempService.save(couponTemp);
        return result ? "新增成功" : "新增失败";
    }
}
