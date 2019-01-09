package com.brs.dbschema.clock.service.impl;

import com.brs.dbschema.clock.entity.ClockRecord;
import com.brs.dbschema.clock.mapper.ClockRecordMapper;
import com.brs.dbschema.clock.service.IClockRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 打卡记录 服务实现类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-20
 */
@Service
public class ClockRecordServiceImpl extends ServiceImpl<ClockRecordMapper, ClockRecord> implements IClockRecordService {

}
