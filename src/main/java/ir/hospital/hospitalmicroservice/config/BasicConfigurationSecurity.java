package ir.hospital.hospitalmicroservice.config;

import ir.hospital.hospitalmicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BasicConfigurationSecurity {
    private final BCryptPasswordEncoder passwordEncoder;
    private final PatientRepository patientRepository;

    public BasicConfigurationSecurity(BCryptPasswordEncoder passwordEncoder, PatientRepository patientRepository) {
        this.passwordEncoder = passwordEncoder;
        this.patientRepository = patientRepository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/register/**")
                        .permitAll())

                .authorizeHttpRequests(
                        (auth) -> auth
                                .requestMatchers(
                                        "/api/v1/patient/**").hasRole("PATIENT"))
                .authorizeHttpRequests((auth) -> auth.anyRequest().permitAll())

                .httpBasic();

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager
            (AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(username -> patientRepository
                        .findByNationalCode(username)
                        .orElseThrow(() -> new UsernameNotFoundException(String
                                .format("this %s not found", username))))
                .passwordEncoder(passwordEncoder);

    }
}