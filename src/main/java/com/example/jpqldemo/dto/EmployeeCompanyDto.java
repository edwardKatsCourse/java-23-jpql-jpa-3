package com.example.jpqldemo.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class EmployeeCompanyDto {

    private String name;
    private String companyName;
}
