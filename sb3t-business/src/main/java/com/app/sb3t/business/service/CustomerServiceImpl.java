package com.app.sb3t.business.service;

import com.app.sb3t.business.domain.CustomerModel;
import com.app.sb3t.business.mapper.CustomerMapper;
import com.app.sb3t.persistence.domain.Customer;
import com.app.sb3t.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.app.sb3t.business.mapper.CustomerMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public int createCustomer(List<CustomerModel> customers) {
        return ((List<Customer>) customerRepository.saveAll(MAPPER.toEntities(customers)))
                .size();
    }

    @Override
    public List<CustomerModel> findCustomers() {
        return MAPPER.toModels((List<Customer>) customerRepository.findAll());
    }
}
