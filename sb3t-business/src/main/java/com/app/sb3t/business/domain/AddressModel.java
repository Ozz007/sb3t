package com.app.sb3t.business.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel {
    private Long id;
    private String streetName;
    private String cityName;
    private String postalCode;
    private String country;
}
