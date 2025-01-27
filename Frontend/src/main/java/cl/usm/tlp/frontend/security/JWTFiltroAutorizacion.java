package cl.usm.tlp.frontend.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JWTFiltroAutorizacion extends OncePerRequestFilter {
	
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
		String token = null;
		
		String bearerToken = request.getHeader("Authorization");
		
		if (null != bearerToken && bearerToken.startsWith("Bearer ")) {
			
			token = bearerToken.replace("Bearer ", "");
			

		}
		
        if (token == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("Authorization".equals(cookie.getName())) {
                        token = cookie.getValue();
                        break;
                    }
                }
            } 
        }
        if (token != null) {
            // Obtener los detalles del usuario del token y establecer la autenticación en el contexto de seguridad
			UsernamePasswordAuthenticationToken usernamePAT = JwtUtil.autorizarToken(token);
			
			SecurityContextHolder.getContext().setAuthentication(usernamePAT);
        }
        
		filterChain.doFilter(request,response);
	}
	

}