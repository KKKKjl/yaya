package com.example.app.filter;

import com.example.app.util.JwtAuth;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private final String JWT_HEADER = "Authorization";

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }
//
//    @Autowired
//    UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String token = request.getHeader(JWT_HEADER);
        if (token == null) {
            chain.doFilter(request, response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(token));
        super.doFilterInternal(request, response, chain);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(JwtAuth.getUsername(token));
        return new UsernamePasswordAuthenticationToken(JwtAuth.getUsername(token), null, null);
    }
}
