package com.example.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * jwt工具类
 *
 * @author Lucky
 * @version 1.0.0
 * @date 2020/8/31 0:21
 * @copyright 老九学堂
 */
public class JwtUtil {

    private static final String SINGNATURE = "HJKSDFKH";

    /**
     * 生成token
     * @return
     */
    public static String getToken(Map<String,String> map){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,3);

        // 创建JWT builder
        JWTCreator.Builder builder = JWT.create();
        // 设置JWT的payload部分
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            builder.withClaim(k, v);
        }
        // 设置令牌过期时间
        String token = builder.withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(SINGNATURE));
        return token;
    }

    /**
     * 验证token，不合法则抛出异常
     * @return
     */
    public static void verify(String token) throws RuntimeException{
        JWT.require(Algorithm.HMAC256(SINGNATURE)).build().verify(token);
    }

    /**
     * 获取token信息
     */
    public static DecodedJWT getTokenInfo(String token){
        return JWT.require(Algorithm.HMAC256(SINGNATURE)).build().verify(token);
    }

}
