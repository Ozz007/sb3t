package com.app.sb3t.persistence.repository;

import com.app.sb3t.persistence.config.AppPersistenceConfigTest;
import com.app.sb3t.persistence.domain.Address;
import com.app.sb3t.persistence.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RequiredArgsConstructor
public class CustomerRepositoryTest extends AppPersistenceConfigTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testCustomerCreate() {

        Customer c = Customer.builder()
                .firstName("fistname")
                .lastName("lastName")
                .email("email@email.com")
                .phoneNumber("0789101512")
                .updtDateTime(OffsetDateTime.now())
                .addresses(Collections.singletonList(Address.builder()
                        .streetName("streetName")
                        .postalCode("postalCode")
                        .cityName("cityName")
                        .country("country")
                        .build()))
                .build();

        customerRepository.save(c);

        log.info("Customer persisted: {}, Address persisted: {}",
                customerRepository.count(),
                addressRepository.count());

        assertThat(customerRepository.count())
                .describedAs("Check Customer Creation")
                .isEqualTo(1L);

        assertThat(addressRepository.count())
                .describedAs("Check Address Creation")
                .isEqualTo(1L);
    }
}
