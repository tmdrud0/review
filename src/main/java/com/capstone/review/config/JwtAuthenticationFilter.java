package com.capstone.review.config;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;

public class JwtAuthenticationFilter extends GenericFilterBean {
    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }
}
