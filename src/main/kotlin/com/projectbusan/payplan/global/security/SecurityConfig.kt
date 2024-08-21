package com.projectbusan.payplan.global.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity) =
        http.cors {it.disable()}
            .csrf { it.disable() }
            .httpBasic { it.disable() }
            .formLogin { it.disable() }
            .sessionManagement { it.disable() }
            .authorizeHttpRequests {
                it.anyRequest()
                    .permitAll()
            }
            .exceptionHandling {

            }
            .build()!!
}