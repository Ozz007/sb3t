package com.app.sb3t.business.mapper;

import com.app.sb3t.business.domain.CustomerModel;
import com.app.sb3t.persistence.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(uses = { AddressMapper.class })
public interface CustomerMapper {

    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    Customer toEntity(CustomerModel customer);
    List<Customer> toEntities(List<CustomerModel> customer);

    CustomerModel toModel(Customer customer);
    List<CustomerModel> toModels(List<Customer> customer);
}
