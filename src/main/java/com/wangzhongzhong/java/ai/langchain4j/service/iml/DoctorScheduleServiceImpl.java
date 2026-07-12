package com.wangzhongzhong.java.ai.langchain4j.service.iml;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhongzhong.java.ai.langchain4j.entity.DoctorSchedule;
import com.wangzhongzhong.java.ai.langchain4j.mapper.DoctorScheduleMapper;
import com.wangzhongzhong.java.ai.langchain4j.service.DoctorScheduleService;
import org.springframework.stereotype.Service;

@Service
public class DoctorScheduleServiceImpl extends ServiceImpl<DoctorScheduleMapper, DoctorSchedule> implements DoctorScheduleService {

}
