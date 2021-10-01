package com.app.sb3t.persistence.repository;

import com.app.sb3t.persistence.domain.Address;
import com.app.sb3t.persistence.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Integer> {
}
