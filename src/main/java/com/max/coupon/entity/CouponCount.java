package com.max.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author max.tu
 * @since 2021-09-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CouponCount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 优惠券id
     */
    private Integer couponTempId;

    /**
     * 活动id
     */
    private Integer activityId;

    /**
     * 剩余库存
     */
    private Integer amount;

    /**
     * 库存限制 0 无 1有
     */
    private Integer inventoryLimit;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 有效期 与start/end time 互斥
     */
    private Integer expiryDate;

    /**
     * 每人限制
     */
    private Integer countLimit;


}
