package com.sylvie.model;


import lombok.*;


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
    private Date date;
}
