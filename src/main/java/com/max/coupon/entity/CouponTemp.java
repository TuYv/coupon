package com.max.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class CouponTemp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "coupon_temp_id", type = IdType.AUTO)
    private Integer couponTempId;

    /**
     * 优惠券模版名
     */
    private String couponTempName;

    /**
     * 优惠券类型 1 满减 2立减 3 折扣
     */
    private Integer type;

    /**
     * 满减目标（仅满减状态有值
     */
    private Integer limit;

    /**
     * 满减额/折扣度
     */
    private String offer;


}
