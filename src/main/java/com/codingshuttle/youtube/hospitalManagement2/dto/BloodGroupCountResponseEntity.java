package com.codingshuttle.youtube.hospitalManagement2.dto;

import com.codingshuttle.youtube.hospitalManagement2.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupCountResponseEntity {
    public BloodGroupType getBloodGroupType() {
        return bloodGroupType;
    }

    public void setBloodGroupType(BloodGroupType bloodGroupType) {
        this.bloodGroupType = bloodGroupType;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    private BloodGroupType bloodGroupType ;
    private Long count ;

}
