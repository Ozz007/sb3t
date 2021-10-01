package com.app.sb3t.business.domain;


import com.app.sb3t.persistence.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private OffsetDateTime updtDateTime;

    private List<AddressModel> addresses;
}
