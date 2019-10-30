package com.sylvie.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.math.BigDecimal;
import java.util.Date;

/**
 * salary
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Salary {

    private Long id;
    //员工id
    private Long employeeId;
    //工资
    private BigDecimal money;
    //所属时间
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+1")
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date month;
}
