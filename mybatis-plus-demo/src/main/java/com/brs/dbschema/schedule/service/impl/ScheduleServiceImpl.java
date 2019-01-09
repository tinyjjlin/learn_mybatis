package com.brs.dbschema.schedule.service.impl;

import com.brs.dbschema.schedule.entity.Schedule;
import com.brs.dbschema.schedule.mapper.ScheduleMapper;
import com.brs.dbschema.schedule.service.IScheduleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 排班（班次） 服务实现类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-17
 */
@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule> implements IScheduleService {

}
