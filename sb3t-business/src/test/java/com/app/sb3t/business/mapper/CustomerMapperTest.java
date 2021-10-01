package com.app.sb3t.business.mapper;

import com.app.sb3t.business.config.AppBusinessConfigTest;
import com.app.sb3t.business.domain.AddressModel;
import com.app.sb3t.business.domain.CustomerModel;
import com.app.sb3t.persistence.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerMapperTest extends AppBusinessConfigTest {

    @Test
    public void testCustomerModelMapper() {
        CustomerModel customerModel = CustomerModel.builder()
                .id(1L)
                .firstName("firstName")
                .lastName("lastName")
                .email("email@email.com")
                .phoneNumber("0789102516")
                .updtDateTime(OffsetDateTime.now())
                .build();

        Customer c = CustomerMapper.MAPPER.toEntity(customerModel);

        assertThat(c).isNotNull();
        assertThat(c.getFirstName()).isEqualTo("firstName");
    }

    @Test
    public void testCustomerModelListMapper() {
        CustomerModel cm1 = CustomerModel.builder()
                .id(1L)
                .firstName("firstName1")
                .lastName("lastName2")
                .email("email@email1.com")
                .phoneNumber("0789102516")
                .updtDateTime(OffsetDateTime.now())
                .addresses(Collections.singletonList(AddressModel.builder()
                                .id(1L)
                                .streetName("streetName")
                                .postalCode("postalCode")
                                .cityName("cityName")
                                .country("country")
                        .build()))
                .build();

        CustomerModel cm2 = CustomerModel.builder()
                .id(2L)
                .firstName("firstName2")
                .lastName("lastName2")
                .email("email@email2.com")
                .phoneNumber("0789102517")
                .updtDateTime(OffsetDateTime.now())
                .build();

        List<CustomerModel> custList = List.of(cm1, cm2);
        List<Customer> customers = CustomerMapper.MAPPER.toEntities(custList);

        SoftAssertions a = new SoftAssertions();

        a.assertThat(customers).describedAs("Check Customer Mapper")
                .isNotNull();
        a.assertThat(customers).describedAs("Check Customer Mapper on list")
                .hasSize(2);
        a.assertThat(customers.get(0).getAddresses()).describedAs("Check Customer Mapper on subelement list")
                        .hasSize(1);
        a.assertAll();
    }

}
