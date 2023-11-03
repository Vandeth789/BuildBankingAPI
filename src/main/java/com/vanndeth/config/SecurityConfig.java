package com.vanndeth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
	    .csrf()
	    .disable()          
	    .authorizeHttpRequests()
	    .requestMatchers("/","index.html", "css/**", "js/**").permitAll()
	    .requestMatchers("/accounts/").hasRole("SALE")
	    .anyRequest()
	    .authenticated()
		.and()
		.httpBasic();
		return http.build();
    }
	
//	@Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authz) -> authz
//        	.requestMatchers("/","index.html", "css/**", "js/**").permitAll()
//        	.requestMatchers("/accounts/").hasRole("SALE")
//        	.anyRequest()
//        	.authenticated())
//            .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
	
//	@Bean
//	protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//	    return httpSecurity
//	        .csrf(csrf -> csrf.disable())
//	        .authorizeHttpRequests(auth -> auth
//        		.requestMatchers("/","index.html", "css/**", "js/**").permitAll()
//        	    .requestMatchers("/accounts/")
//        	    .hasRole("SALE")
//	            .anyRequest()
//	            .authenticated()
//	        )
//	        .httpBasic(Customizer.withDefaults())
//	        .build();
//	}

	
	@Bean
	protected UserDetailsService userDetailsService() {
		
//		UserDetails user1 = new User("dara", passwordEncoder.encode("dara111"), Collections.emptyList());
		
		UserDetails user1 = User.builder()
				.username("dara")
				.password(passwordEncoder.encode("dara111"))
				.roles("ADMIN") // => ROLE_ADMIN
				.build();
		
		UserDetails user2 = User.builder()
				.username("sara")
				.password(passwordEncoder.encode("sara111"))
				.roles("SALE") // => ROLE_SALE
				.build();
		
		UserDetailsService userDetailsService = new InMemoryUserDetailsManager(user1, user2);
		return userDetailsService;
	}
	

}
