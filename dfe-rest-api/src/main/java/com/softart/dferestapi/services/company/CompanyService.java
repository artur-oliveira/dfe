package com.softart.dferestapi.services.company;

import com.softart.dferestapi.models.company.Company;
import com.softart.dferestapi.models.company.request.CompanyPartialUpdateRequest;
import com.softart.dferestapi.models.company.request.CompanyRequest;
import com.softart.dferestapi.models.company.request.CompanyUpdateRequest;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    Company findById(Long id);

    Company createCompany(CompanyRequest companyRequest);

    Company updateCompany(CompanyUpdateRequest updateRequest);

    Company partialUpdateCompany(CompanyPartialUpdateRequest updateRequest);

}
