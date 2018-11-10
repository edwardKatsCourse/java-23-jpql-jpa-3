package com.example.jpqldemo.reposiotry;

import com.example.jpqldemo.dto.EmployeeCompanyDto;
import com.example.jpqldemo.model.Company;

import java.util.List;

public interface CompanyRepositoryCustom {

    void saveEntity(String companyName);

    Company searchByCompanyName(String name);

    List<EmployeeCompanyDto> findEmployeeByCompanyName(String companyName);
}
