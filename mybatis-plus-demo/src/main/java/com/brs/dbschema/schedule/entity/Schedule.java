package com.brs.dbschema.schedule.entity;

import java.time.LocalTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 排班（班次）
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 班次名称
     */
    private String name;

    /**
     * 是否启用，1代表启用；0代表禁止。
     */
    private Integer enabled;

    /**
     * 上班时间
     */
    private LocalTime workingHours;

    /**
     * 最早上班时间
     */
    private LocalTime earliestWorkingHours;

    /**
     * 最迟上班时间
     */
    private LocalTime lastestWorkingHours;

    /**
     * 下班时间 
     */
    private LocalTime offHours;

    /**
     * 下班最早有效时间
     */
    private LocalTime earliestOffHours;

    /**
     * 最晚下班时间
     */
    private LocalTime lastestOffHours;


}
