package com.example.jpqldemo.reposiotry;

import com.example.jpqldemo.dto.EmployeeCompanyDto;
import com.example.jpqldemo.model.Company;
import com.example.jpqldemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public class CompanyRepositoryCustomImpl implements CompanyRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Company searchByCompanyName(String name) {
        return (Company) entityManager.createQuery("from Company c where c.companyName = :name")
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<EmployeeCompanyDto> findEmployeeByCompanyName(String companyName) {
//        Employee e = ((Employee) entityManager.createQuery(
//                "select e from Employee e where e.company.companyName = :name"
//        )
//                .setParameter("name", companyName)
//                .getSingleResult());
//
//        Company company = e.getCompany();


        //Fetching strategy:
        //- lazy (default)
        //- eager

        //int(1) -> 1/0

        List<EmployeeCompanyDto> employees = entityManager.createQuery("select " +
                "new com.example.jpqldemo.dto.EmployeeCompanyDto(e.name, e.company.companyName) " +
                "from Employee e " +
                "where e.company.companyName = :name")
                .setParameter("name", companyName)
                .getResultList();

        return employees;
    }

    @Override
    @Transactional
    public void saveEntity(String companyName) {
//        entityManager.getCriteriaBuilder();

        Company company = new Company();
        company.setCompanyName(companyName);

        entityManager.persist(company);

        System.out.println(company);

//        Query query = entityManager.createQuery("select c from Company c where c.companyName " +
//                "= :name");
//        query.setParameter("name", "Google");

        /**
         * begin transaction -> "transactionId"
         *  insert
         *  update
         *  update
         *  update
         *  update
         *  insert
         *  insert
         *  update
         *  update
         *  update <- exception - rollback
         * end transaction -> commit
         */
    }
}
