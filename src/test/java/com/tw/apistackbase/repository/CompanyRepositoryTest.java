package com.tw.apistackbase.repository;

import com.tw.apistackbase.core.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CompanyRepositoryTest {
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void should_save_and_fetch_company_entity() {
        Company company = new Company();
        company.setName("Company");

        Company companyInDb = companyRepository.save(company);
        Company companyFetched = companyRepository.findById(companyInDb.getId()).orElse(null);

        assertNotNull(companyFetched);
        assertEquals(company.getName(), companyFetched.getName());
    }

    @Test
    public void should_not_save_company_when_name_is_null() {
        Company company = new Company();
        assertThrows(Exception.class, () -> companyRepository.saveAndFlush(company));
    }

    @Test
    public void should_not_save_company_when_length_of_name_more_than_64() {
        Company company = new Company();
        company.setName("This is a fucking loooooooooooooooooooooooooooooooooooong name test for company.");

        assertThrows(Exception.class, () -> companyRepository.saveAndFlush(company));
    }
}