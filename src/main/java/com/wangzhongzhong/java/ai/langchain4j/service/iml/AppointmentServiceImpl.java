package com.wangzhongzhong.java.ai.langchain4j.service.iml;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangzhongzhong.java.ai.langchain4j.entity.Appointment;
import com.wangzhongzhong.java.ai.langchain4j.mapper.AppointmentMapper;
import com.wangzhongzhong.java.ai.langchain4j.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements AppointmentService {

    @Override
    public Appointment getOne(Appointment appointment) {
        return getBaseMapper().selectOne(new LambdaQueryWrapper<Appointment>()
                .eq(Appointment::getUsername, appointment.getUsername())
                .eq(Appointment::getIdCard, appointment.getIdCard())
                .eq(Appointment::getDepartment, appointment.getDepartment())
                .eq(Appointment::getDate, appointment.getDate())
                .eq(Appointment::getTime, appointment.getTime())
                .eq(Appointment::getDoctorName, appointment.getDoctorName()));
    }
}
