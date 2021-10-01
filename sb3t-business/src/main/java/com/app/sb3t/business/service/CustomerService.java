package com.app.sb3t.business.service;

import com.app.sb3t.business.domain.CustomerModel;

import java.util.List;


public interface CustomerService {

    /**
     * Create customer
     * @param customers list of customers
     * @return saved count
     */
    int createCustomer(List<CustomerModel> customers);

    /**
     * Consult customers
     * @return list of customers
     */
    List<CustomerModel> findCustomers();
}
