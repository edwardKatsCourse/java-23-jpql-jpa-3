package com.example.jpqldemo;

import com.example.jpqldemo.dto.EmployeeCompanyDto;
import com.example.jpqldemo.model.Company;
import com.example.jpqldemo.model.Employee;
import com.example.jpqldemo.reposiotry.CompanyRepository;
import com.example.jpqldemo.reposiotry.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {


    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello");

        companyRepository.saveEntity("Google");

        Company company = companyRepository.searchByCompanyName("Google");

        Employee e1 = new Employee();
        e1.setCompany(company);
        e1.setName("John Doe");

        employeeRepository.save(e1);

        Employee e2 = new Employee();
        e2.setCompany(company);
        e2.setName("Peter Dale");
        employeeRepository.save(e2);

        List<EmployeeCompanyDto> employeeCompanyDtos = companyRepository.findEmployeeByCompanyName("Google");
        System.out.println(employeeCompanyDtos);
    }
}
