package com.sourcecode.springboot.tomcatwar.config.mvc.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter
@Component
public class WWFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("init web filter: MyFilter--config: " + filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("do filter MyFilter -- " + request);
        System.err.println("do filter MyFilter -- " + response);
        request.setAttribute("my_filter", "wangwei");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.err.println("destroy web filter: MyFilter--config");
    }
}
