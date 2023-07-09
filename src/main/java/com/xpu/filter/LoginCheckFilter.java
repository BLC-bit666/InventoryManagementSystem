package com.xpu.filter;

import com.alibaba.fastjson.JSON;
import com.xpu.common.BaseContext;
import com.xpu.common.R;
import org.springframework.util.AntPathMatcher;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.filter
 * @Author: BLC
 * @CreateTime: 2023-07-06  14:50
 * @Description: 登录检查过滤器
 * @Version: 1.0
 */
//检查用户是否已经完成登录
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    /**
     * @description: 登录状态判断
     * @param: [servletRequest, servletResponse, filterChain]
     * @return: void
     * @author: BLC
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1、获取本次请求的URI
        String requestURI = request.getRequestURI();
        //定义不需要处理的路径
        String[] URLS = {
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/common/**"
        };
        //2、判断本次请求是否需要处理
        if (check(URLS, requestURI)) {
            filterChain.doFilter(request, response);
            return;
        }

        //3、判断登录状态，决定是否放行
        Long employeeId = (Long) request.getSession().getAttribute("employee");
        if (employeeId != null) {
            BaseContext.setCurrentId(employeeId);
            filterChain.doFilter(request, response);
            return;
        }
        //4、如果未登录，则使用输出流向客户端响应json数据
        response.getWriter().write(JSON.toJSONString(R.error("NOT LOGIN")));
    }

    /**
     * @description: 路径匹配，检查本次请求是否需要放行
     * @return: boolean
     * @author: BLC
     */
    public boolean check(String[] URLS, String requestURI) {
        for (String url : URLS) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
