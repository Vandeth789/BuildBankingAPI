package com.vanndeth.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.vanndeth.entity.AccountType;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class AccountTypeSpec implements Specification<AccountType> {
	private final AccountTypeFilter accountTypeFilter;

	List<Predicate> predicates = new ArrayList<>();

	@Override
	public Predicate toPredicate(Root<AccountType> accountType, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (accountTypeFilter.getAccountTypesCode() != null) {
//			Predicate code = accountType.get("accountTypesCode").in(accountTypeFilter.getAccountTypesCode());
			Predicate code = cb.like(cb.upper(accountType.get("accountTypesCode")),
					"%" + accountTypeFilter.getAccountTypesCode().toUpperCase() + "%");
			predicates.add(code);
		}

		if (accountTypeFilter.getAccountTypesDescription() != null) {
//			Predicate desc = accountType.get("accountTypesDescription").in(accountTypeFilter.getAccountTypesDescription());
			Predicate desc = cb.like(cb.upper(accountType.get("accountTypesDescription")),
					"%" + accountTypeFilter.getAccountTypesDescription().toUpperCase() + "%");
			predicates.add(desc);
		}
//		cb.and(predicates.toArray(new Predicate[0]));
		return cb.and(predicates.toArray(Predicate[]::new));
	}

}
