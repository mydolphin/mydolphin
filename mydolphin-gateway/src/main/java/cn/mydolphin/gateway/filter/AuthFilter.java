package cn.mydolphin.gateway.filter;

import cn.mydolphin.gateway.auth.config.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Resource
    JwtConfig jwtConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        //无需校验的url
        String authIgnoreUrl = jwtConfig.getAuthIgnoreUrl();
        String[] authIgnoreUrls = authIgnoreUrl.split(",");
        for (String url: authIgnoreUrls) {
            if(httpServletRequest.getServletPath().equals(url)) {
                filterChain.doFilter(httpServletRequest,httpServletResponse);
                return;
            }
        }
    }
}
