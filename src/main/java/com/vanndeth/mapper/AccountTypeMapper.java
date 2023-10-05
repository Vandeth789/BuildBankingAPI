package com.vanndeth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.vanndeth.dto.AccountTypeDTO;
import com.vanndeth.entity.AccountType;

@Mapper
public interface AccountTypeMapper {
	
	AccountTypeMapper INSTANCE = Mappers.getMapper(AccountTypeMapper.class);
	
	@Mapping(target = "accountTypesCode", ignore = true)
	AccountType toAccountType(AccountTypeDTO accountTypeDTO);
	
	AccountTypeDTO toAccountTypeDTO(AccountType accountType);
}
