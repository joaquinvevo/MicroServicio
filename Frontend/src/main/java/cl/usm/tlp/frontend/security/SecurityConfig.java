package cl.usm.tlp.frontend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cl.usm.tlp.frontend.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private final JWTFiltroAutorizacion filtroAutorizacion;
    private final UserDetailsServiceImpl userService;

    // Usamos AuthenticationManagerBuilder para crear el AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());
        return authBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Usamos el AuthenticationManager creado como bean
        AuthenticationManager authManager = authenticationManager(http);

        JwtFiltroAutenticacion filtroAutenticacion = new JwtFiltroAutenticacion(authManager);
        filtroAutenticacion.setFilterProcessesUrl("/login");

        http.csrf().disable()
        .authorizeHttpRequests(authorize -> authorize
            .antMatchers("/css/**", "/js/**", "/images/**", "/webjars/**", "/AdminLTE-3.2.0/plugins/fontawesome-free/webfonts/**").permitAll()
            .antMatchers("/ingresar").permitAll()
            .antMatchers("/registrarse").permitAll()
            .antMatchers("/register").permitAll()
            .anyRequest().authenticated()
        )
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .exceptionHandling(exception -> exception
            .accessDeniedHandler(accessDeniedHandler())
            .authenticationEntryPoint(authenticationEntryPoint())
        )
        .addFilter(filtroAutenticacion)
        .addFilterBefore(filtroAutorizacion, UsernamePasswordAuthenticationFilter.class);

    return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
            response.sendRedirect("/ingresar");
        };
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> {
            response.sendRedirect("/admin/modelo");
        };
    }
}