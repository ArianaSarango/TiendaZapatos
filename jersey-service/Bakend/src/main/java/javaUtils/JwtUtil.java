package javaUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class JwtUtil {
    // Generar clave segura
    public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    
    // Método para obtener clave en Base64 (ASCII seguro)
    public static String getBase64SecretKey() {
        return Base64.getEncoder().encodeToString(SECRET_KEY.getEncoded());
    }

    public static String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 7200000)) // 2 horas
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .compact();
    }

    public static void main(String[] args) {
        String clave = Base64.getEncoder().encodeToString(Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded());
        System.out.println("CLAVE_BASE64: " + clave);
    }

}