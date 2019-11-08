package com.example.app.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.logging.Logger;

public class JwtAuth {
    private static byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("C*F-JaNdRgUkXn2r5u8x/A?D(G+KbPeShVmYq3s6v9y$B&E)H@McQfTjWnZr4u7w");

    private static SecretKey secretKey = Keys.hmacShaKeyFor(apiKeySecretBytes);
    private static final String TOKEN_PREFIX = "Bearer ";
    private static final Logger logger = Logger.getLogger(JwtAuth.class.getName());

    public static String generateJwtToken(Long id) {
        String token = Jwts.builder()
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .setAudience(String.valueOf(id))
                .compact();
        logger.warning(token);
        return TOKEN_PREFIX + token;
    }

    public static Claims parseJwtToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
        } catch (Exception e) {
            logger.warning("parse jwt token failed: " + e);
            return null;
        }
    }

    public static String getUserId(String token) {
        return parseJwtToken(token).getAudience();
    }

//    public Boolean isExperied(String token) {
//        Date exp = (Date) this.parseJwtToken(token).getExpiration();
//        return exp.before(new java.util.Date());
//    }
}
