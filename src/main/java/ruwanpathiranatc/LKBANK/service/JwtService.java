package ruwanpathiranatc.LKBANK.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Service
public class JwtService {
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 1 day
    @Value("${jwtSecret}")
    private String jwtSecret;
    public SecretKey generateKey() {
        byte[] keyBytes = jwtSecret.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String userName) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);
        return io.jsonwebtoken.Jwts.builder()
                .subject(userName)
                .issuedAt(now)
                .expiration(expirationDate)
                .signWith(generateKey())
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractSubject(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean isTokenValid(String token) {
        return !isTokenExpired(token);
    }

    public Date extractExpiration(String token) {
        return extractClaims(token).getExpiration();
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }







}
