package com.templateproject.api.controller;

import org.springframework.stereotype.Component;

import com.templateproject.api.service.AuthService;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class AuthFilter implements Filter {

    private final AuthService authService;

    AuthFilter(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        var request = (HttpServletRequest) servletRequest;
        var response = (HttpServletResponse) servletResponse;

        var path = request.getServletPath();
        if (!path.equals("/register") && !path.equals("/login")) {
            var token = request.getHeader("x-token");
            Integer playerID = authService.findUserIdByToken(token);
            if (playerID == null) {
                response.setHeader("Content-type", "application/json");
                response.setStatus(401);
                response.getWriter().println("{" +
                        "\"message\" : \"Invalid Token\"" +
                        "}");
                return;
            }
            request.setAttribute("playerID", playerID);
        }
        chain.doFilter(request, response);
    }
}