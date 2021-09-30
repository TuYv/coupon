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
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 开始时间
     */
    private LocalDate startTime;

    /**
     * 结束实现
     */
    private LocalDate endTime;

    /**
     * 状态0 审核中 1 已审核 2已上线 3已结束
     */
    private Integer status;


}
