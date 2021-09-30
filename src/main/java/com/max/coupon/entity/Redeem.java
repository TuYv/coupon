package com.max.com.max.mapper.entity;

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
public class Redeem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 兑换码
     */
    private String redeemCode;

    /**
     * 优惠券id
     */
    private Integer couponCountId;

    /**
     * 0未使用 1已使用 2已过期
     */
    private Integer status;


}
