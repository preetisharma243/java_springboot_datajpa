package com.psit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psit.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
