package com.example.app.filter;

import com.example.app.model.JwtUser;
import com.example.app.util.JwtAuth;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private Logger logger = Logger.getLogger(JwtAuthenticationFilter.class.getName());

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super.setFilterProcessesUrl("/v1/api/auth");
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String username = request.getParameter("nickname");
        String password = request.getParameter("password");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        setDetails(request, token);
        return getAuthenticationManager().authenticate(token);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        response.setHeader("Authorization", JwtAuth.generateJwtToken(jwtUser.getUsername()));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, failed.getMessage());
    }
}
