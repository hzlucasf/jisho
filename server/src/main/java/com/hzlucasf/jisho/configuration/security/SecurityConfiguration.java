package com.hzlucasf.jisho.configuration.security;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Value("${rsa.key.public}")
    private RSAPublicKey publicKey;

    @Value("${rsa.key.private}")
    private RSAPrivateKey privateKey;

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorize -> authorize.requestMatchers(
                                HttpMethod.POST,
                                "/sign-up"
                        ).permitAll().anyRequest().denyAll()
                )
                .build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new Argon2PasswordEncoder(
                16,
                32,
                1,
                1 << 14,
                2
        );
    }

    @Bean
    public JwtEncoder getJwtEncoder() {
        var jwk = new RSAKey.Builder(publicKey).privateKey(privateKey).build();

        var jwkSet = new ImmutableJWKSet<>(new JWKSet(jwk));

        return new NimbusJwtEncoder(jwkSet);
    }
}
