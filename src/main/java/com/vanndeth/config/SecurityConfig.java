package com.vanndeth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true
)
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
        	.authorizeHttpRequests((authz) -> authz
        	.requestMatchers("/","index.html", "css/**", "js/**").permitAll()
        	// .requestMatchers("/customers/").hasRole(RoleEnum.SALE.name())
        	// .requestMatchers(HttpMethod.POST, "/accounts/").hasAuthority("brand:write")
        	// .requestMatchers(HttpMethod.POST, "/accounts/").hasAuthority(ACCOUNT_WRITE.getDescription())
        	// .requestMatchers(HttpMethod.GET, "/accounts/").hasAuthority(ACCOUNT_READ.getDescription())
        	.anyRequest()
        	.authenticated())
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
	
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails user1 = User.builder()
				.username("dara")
				.password(passwordEncoder.encode("dara111"))
				.authorities(RoleEnum.ADMIN.getAuthorities())
				.build();
		
		UserDetails user2 = User.builder()
				.username("sara")
				.password(passwordEncoder.encode("sara111"))
				.authorities(RoleEnum.SALE.getAuthorities())
				.build();
		
		return new InMemoryUserDetailsManager(user1, user2);
	}

}
