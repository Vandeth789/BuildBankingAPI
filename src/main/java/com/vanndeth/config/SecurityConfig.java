package com.vanndeth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.vanndeth.config.jwt.JwtLoginFilter;
import com.vanndeth.config.jwt.TokenVerifyFilter;


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
	
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;
	
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
	     return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
        	.addFilter(new JwtLoginFilter(authenticationManager()))
        	.addFilterAfter(new TokenVerifyFilter(), JwtLoginFilter.class)
        	.sessionManagement((session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)))
        	.authorizeHttpRequests((authz) -> authz
        	.requestMatchers("/","index.html", "css/**", "js/**").permitAll()
        	.anyRequest()
        	.authenticated());
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
