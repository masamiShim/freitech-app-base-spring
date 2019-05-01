package com.genius.solar.freitech.config;

import com.genius.solar.freitech.domain.UserId;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserIdConverter implements AttributeConverter<UserId, String> {
    @Override
    public String convertToDatabaseColumn(UserId userId) {
        return (userId == null ? null : userId.getUserId());
    }

    @Override
    public UserId convertToEntityAttribute(String userId) {
        return (userId == null ? null : new UserId(userId));
    }
}
