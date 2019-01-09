package com.brs.dbschema.attendance.service.impl;

import com.brs.dbschema.attendance.entity.AttendanceRecord;
import com.brs.dbschema.attendance.mapper.AttendanceRecordMapper;
import com.brs.dbschema.attendance.service.IAttendanceRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考勤（打卡）记录 服务实现类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-18
 */
@Service
public class AttendanceRecordServiceImpl extends ServiceImpl<AttendanceRecordMapper, AttendanceRecord> implements IAttendanceRecordService {

}
