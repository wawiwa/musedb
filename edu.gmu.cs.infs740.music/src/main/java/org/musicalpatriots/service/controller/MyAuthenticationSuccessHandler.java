package org.musicalpatriots.service.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

//@Component
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    //@Autowired
    //private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException {
    	
    	System.out.println("Login Auth Handler...");

        // changeLastLoginTime(username)
        //userService.changeLastLoginTime(authentication.getName());

        setDefaultTargetUrl("/success");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}