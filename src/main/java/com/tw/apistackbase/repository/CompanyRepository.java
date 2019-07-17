package com.tw.apistackbase.repository;

import com.tw.apistackbase.core.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query
    public List<Company> findByName(String name);

}
