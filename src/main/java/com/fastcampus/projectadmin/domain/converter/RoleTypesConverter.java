package com.fastcampus.projectadmin.domain.converter;

import com.fastcampus.projectadmin.domain.constant.RoleType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Converter(autoApply = true)
public class RoleTypesConverter implements AttributeConverter<Set<RoleType>, String> {

    private static final String DELIMTER = ",";
    @Override
    public String convertToDatabaseColumn(Set<RoleType> attribute) {
        return attribute.stream().map(RoleType::name).sorted().collect(Collectors.joining(DELIMTER));
    }

    @Override
    public Set<RoleType> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(DELIMTER)).map(RoleType::valueOf).collect(Collectors.toSet());
    }
}
