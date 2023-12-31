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
        if (!path.equals("/register") && !path.equals("/login")
                && !request.getMethod().toLowerCase().equals("options")) {

            var token = request.getHeader("x-token");
            System.out.println(token + " token back");
            response.setHeader("Access-Control-Allow-Origin", "*");

            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS, DELETE, PUT, PATCH");
            response.setHeader("Access-Control-Allow-Headers",
                    "Origin, Accept, X-Requested-With,Content-Type,Access-Control-Request-Method, Access-Control-Request-Headers");

            Integer playerID = authService.findUserIdByToken(token);
            System.out.println("In filter PLayer ID is :" + playerID);
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