package com.example.L13_Spring_Security_Intro.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AppRequestFilter extends HttpFilter {

    private static Logger log = LoggerFactory.getLogger(AppRequestFilter.class);

    @Override
    public void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        log.info("Processing in AppRequestFilter before controller");
        filterChain.doFilter(httpServletRequest,httpServletResponse);
        log.info("Processing in AppRequestFilter before sending response");
    }
}
