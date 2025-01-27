package cl.usm.tlp.frontend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    private final static String ACCESS_TOKEN_SECRET = "hJ8jGmQ8kJ9sKxA3kA2w5A2fJ2gF7mD6tR3oU4kZ8jL9gH3tR6fS9mD5pQ8zJ1bH7vN5qA2pH3tW9zQ4kV8rG6xL0yK1pD7uM5jT9xW6gL5fQ4bP2nA3mZ8yH6cR7eX4qF8vK2lD6tR8nM3kB5xF9";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS= 86_400L;
    
    private JwtUtil() {
    	
    }
    
    public static String crearToken(String nombre, String email) {
    	Long tiempoExpiracion  = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
    	Date fechaExpiracion = (new Date(System.currentTimeMillis() + tiempoExpiracion));
    	Map<String, Object> extraClaims = new HashMap<>();
    	extraClaims.put("nombre", nombre);
    	
    	return Jwts.builder()
    			.setSubject(email)
    			.setExpiration(fechaExpiracion)
    			.addClaims(extraClaims)
    			.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
    			.compact();
    }
    
    public static UsernamePasswordAuthenticationToken autorizarToken(String token) {
    	token = token.replace ("Bearer ", "");
    	try {
    		Claims claims = Jwts.parserBuilder()
    				.setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
    				.build()
    				.parseClaimsJws(token)
    				.getBody();
    		
    		String email = claims.getSubject();
    		
    		return new UsernamePasswordAuthenticationToken(email,null,Collections.emptyList());
    	}
    	catch (Exception e){
    		return null;
    	}
    }    
}