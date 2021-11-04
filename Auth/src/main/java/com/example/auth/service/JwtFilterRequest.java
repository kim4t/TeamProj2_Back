package com.example.auth.service;

import com.example.auth.utill.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtFilterRequest extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        String userName = null;
        String password = null;
        String jwtToken = null;
        if(header != null && header.startsWith("Bearer ")){
            jwtToken = header.substring(7);
            userName = jwtUtil.extractUserName(jwtToken);
        }
        if(userName != null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails currentUserDetails = userService.loadUserByUsername(userName);
            Boolean tokenValidation = jwtUtil.validateToken(jwtToken,currentUserDetails);
            if(tokenValidation){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        =  new UsernamePasswordAuthenticationToken(currentUserDetails,null,currentUserDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
