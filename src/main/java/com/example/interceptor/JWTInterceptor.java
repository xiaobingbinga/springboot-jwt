package com.example.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.util.JsonResult;
import com.example.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配置拦截器
 *
 * @author Lucky
 * @version 1.0.0
 * @date 2020/8/31 9:35
 * @copyright 老九学堂
 */
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        JsonResult result = new JsonResult();
        try {
            JwtUtil.verify(token);
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
        } catch (TokenExpiredException e) {
            result.setMsg("token过期");
        } catch (AlgorithmMismatchException e) {
            result.setMsg("token算法不一致");
        } catch (Exception e) {
            result.setMsg("token无效");
        }
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
        return false;
    }
}
