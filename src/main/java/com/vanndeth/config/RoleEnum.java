package com.vanndeth.config;

import static com.vanndeth.config.PermissionEnum.ACCOUNT_READ;
import static com.vanndeth.config.PermissionEnum.ACCOUNT_WRITE;
import static com.vanndeth.config.PermissionEnum.CUSTOMER_READ;
import static com.vanndeth.config.PermissionEnum.CUSTOMER_WRITE;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleEnum {
	ADMIN(Set.of(ACCOUNT_WRITE, ACCOUNT_READ, CUSTOMER_WRITE, CUSTOMER_READ)), 
	SALE(Set.of(ACCOUNT_READ, CUSTOMER_READ));

	private Set<PermissionEnum> permissions;

	public Set<SimpleGrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> grantedAuthorities = this.permissions
		    .stream()
		    .map(permission -> new SimpleGrantedAuthority(permission.getDescription()))
		    .collect(Collectors.toSet());
		SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_" + this.name());
		grantedAuthorities.add(role);
//		System.out.println(grantedAuthorities);
		return grantedAuthorities;
	}
}
