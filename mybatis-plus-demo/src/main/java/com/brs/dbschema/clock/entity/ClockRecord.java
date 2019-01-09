package com.brs.dbschema.clock.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 打卡记录
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ClockRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 打卡日期
     */
    private LocalDate clockDay;

    /**
     * 员工工号
     */
    private Integer empNo;

    /**
     * 打卡时间
     */
    private LocalDateTime clockTime;

    /**
     * 打卡方式
     */
    private Integer clockTypeCode;

    /**
     * 定点位置
     */
    private String position;


}
