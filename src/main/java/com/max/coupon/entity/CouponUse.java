package com.max.com.max.mapper.entity;

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
public class CouponUse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 优惠券id
     */
    private Integer couponCountId;

    /**
     * 有效起期
     */
    private LocalDate startTime;

    /**
     * 有效止期
     */
    private LocalDate endTime;

    /**
     * 0未使用 1已使用 2 已过期 
     */
    private Integer status;


}
