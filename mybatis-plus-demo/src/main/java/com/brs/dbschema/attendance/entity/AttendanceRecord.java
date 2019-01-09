package com.brs.dbschema.attendance.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 考勤（打卡）记录
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AttendanceRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 打卡日期
     */
    private LocalDate clockInTime;

    /**
     * 员工工号
     */
    private Integer empNo;

    /**
     * 打卡记录
     */
    private LocalDateTime clockInRecord;


}
