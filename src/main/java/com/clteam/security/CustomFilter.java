package com.clteam.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Khanh Nguyen on 8/5/2017.
 */
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        // check cookie and nontify if disabled cookie
        System.out.println("### do filter...");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if (request.getCookies() == null) {
            System.out.println("### cookie is null");
            try {
                request.setAttribute("error", "You must enable cookie to login!");
                request.getRequestDispatcher("/login").forward(request, response);
                //response.sendRedirect("/login");
            }  catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("### cookie not null");
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
