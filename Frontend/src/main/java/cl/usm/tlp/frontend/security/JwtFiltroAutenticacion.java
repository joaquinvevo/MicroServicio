package cl.usm.tlp.frontend.security;


import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;



public class JwtFiltroAutenticacion extends UsernamePasswordAuthenticationFilter {

    public JwtFiltroAutenticacion(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);  // Set the AuthenticationManager
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        CredencialesAutenticacion credenciales = new CredencialesAutenticacion();
        try {
            credenciales = new ObjectMapper().readValue(request.getReader(), CredencialesAutenticacion.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        UsernamePasswordAuthenticationToken usuarioPAT = new UsernamePasswordAuthenticationToken(
            credenciales.getEmail(), credenciales.getPassword(), Collections.emptyList()
        );

        try {
            return getAuthenticationManager().authenticate(usuarioPAT);
        } catch (AuthenticationException e) {
            // Si falla la autenticación, devuelve un error y maneja IOException
            try {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Credenciales inválidas");
                response.getWriter().flush();
            } catch (IOException ioException) {
                ioException.printStackTrace(); // Para capturar cualquier IOException
            }
            return null;
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        UserDetailsImpl detalles = (UserDetailsImpl) authResult.getPrincipal();
        String token = JwtUtil.crearToken(detalles.getNombre(), detalles.getUsername());

        response.addHeader("Authorization", "Bearer " + token);

        Cookie jwtCookie = new Cookie("Authorization", token);
        jwtCookie.setHttpOnly(true); // Set as HttpOnly for extra security
        jwtCookie.setSecure(false); // Change to true in a secure environment (HTTPS)
        jwtCookie.setPath("/");

        System.out.println("Estableciendo cookie: " + jwtCookie.getName() + " con valor: " + jwtCookie.getValue());

        response.addCookie(jwtCookie);
        response.sendRedirect("/admin/modelo");
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}