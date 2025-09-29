package com.niraj.usermanagement.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;
@Component
public class JwtUtil {

     private final String   SECRET="nineseptembertwothousandtwentyfivetwelvethirtyonesaturdaygreaternoidaindia";
     private final long expiration_time=1000*60*60;
     private final Key key= Keys.hmacShaKeyFor(SECRET.getBytes());
     public String generateToken(String subject) {
      return    Jwts.builder()
                 .setSubject(subject)
                 .setIssuedAt(new Date())
                 .setExpiration(new Date(System.currentTimeMillis()+expiration_time))
                 .signWith(key, SignatureAlgorithm.HS256)
                 .compact();
     }
    // 4️⃣ Generic claim extractor
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }
     public String extactUserName(String token) {
         return extractClaim(token,Claims::getSubject);
     }
     public Date extactExpirationDate(String token) {
         return extractClaim(token,Claims::getExpiration);

     }
     public boolean extactIsExpired(String token) {
         return extractClaim(token,Claims::getExpiration).before(new Date());
     }
     public boolean validateToken(String token,String username) {
         return username.equals(extactUserName(token)) &&!extactIsExpired(token);

     }
}
