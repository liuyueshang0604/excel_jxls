package com.cn.excel_jxls.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Employee {
    private String name;
    private Date birthDate;
    private BigDecimal payment;
    private BigDecimal bonus;
    private String salaryGroup;
    public Employee(String name, Date birthDate, BigDecimal payment, BigDecimal bonus) {
        this.name = name;
        this.birthDate = birthDate;
        this.payment = payment;
        this.bonus = bonus;
        this.salaryGroup = getSalaryGroup();
    }

    public String getSalaryGroup() {
        return payment.doubleValue() > 2000d ? "high" : "normal";
    }
}
