package com.wangzhongzhong.java.ai.langchain4j.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("doctor_schedule")
public class DoctorSchedule {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String doctorName;
    private String department;
    private String date;
    private String time;
    private Integer maxPatients;
}
