package com.max.coupon.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.max.coupon.controller.CouponUseController;
import com.max.coupon.entity.CouponCount;
import com.max.coupon.entity.CouponTemp;
import com.max.coupon.service.ICouponCountService;
import com.max.coupon.service.ICouponTempService;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CouponTempServiceImplTest {

    @Autowired
    ICouponTempService couponTempService;
    @Autowired
    ICouponCountService couponCountService;
    @Autowired
    CouponUseController couponUseController;

    CountDownLatch countDownLatch;
    @Test
    public void insertCouponTemp() {
        CouponTemp couponTemp = new CouponTemp();
        couponTemp.setCouponTempName("五元立减券");
        couponTemp.setType(2);
        couponTemp.setOffer("5");

        Boolean b = couponTempService.save(couponTemp);
        System.out.println(b);
    }

    @Test
    public void insertCouponCount() {
        CouponCount couponCount = new CouponCount();
        couponCount.setCouponTempId(2);
        couponCount.setInventoryLimit(1);
        couponCount.setAmount(10);
        couponCount.setExpiryDate(30);
        couponCount.setCountLimit(1);

        Boolean b = couponCountService.save(couponCount);
        System.out.println(b);
    }

    /**
     * 模拟获得优惠券的场景
     */
    @Test
    public void getCoupon() throws InterruptedException {
        countDownLatch = new CountDownLatch(100000);
        for (int i = 1; i < 100001; i++) {
            Thread t = new MyThread(String.valueOf(i));
            t.start();
        }
        countDownLatch.await();
        System.out.println("等待完毕 主线程执行");
    }

    public class MyThread extends Thread {

        private String no;

        public MyThread(String no) {
            this.no = no;
        }
        @Override
        public void run() {
            String result = couponUseController.getCoupon(Integer.parseInt(no),2,1);
            System.out.println(this.no + result);
            countDownLatch.countDown();
        }
    }
}