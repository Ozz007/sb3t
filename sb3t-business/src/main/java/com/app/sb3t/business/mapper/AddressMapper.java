package com.app.sb3t.business.mapper;

import com.app.sb3t.business.domain.AddressModel;
import com.app.sb3t.persistence.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper MAPPER = Mappers.getMapper(AddressMapper.class);

    AddressModel toEntity(Address address);
    Address toModel(AddressModel address);
}
