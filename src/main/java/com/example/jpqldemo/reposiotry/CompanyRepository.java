package com.example.jpqldemo.reposiotry;

import com.example.jpqldemo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends CompanyRepositoryCustom, JpaRepository<Company, Long> {

    @Query("select c from Company c where c.companyName = :name")
    Company search(@Param("name") String name);
}
