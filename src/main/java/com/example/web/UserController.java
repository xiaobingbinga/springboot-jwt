package com.example.web;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.domain.User;
import com.example.service.UserService;
import com.example.util.JwtUtil;
import com.example.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lucky
 * @version 1.0.0
 * @date 2020/8/31 1:37
 * @copyright 老九学堂
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public JsonResult login(User query){
        log.info("用户名：[{}]",query.getAccount());
        log.info("密码：[{}]",query.getPassword());

        JsonResult result = new JsonResult();
        try {
            User user = userService.login(query);

            // 生成token
            Map<String,String> payload = new HashMap<>();
            payload.put("id",user.getId().toString());
            payload.put("account",user.getAccount());
            String token = JwtUtil.getToken(payload);

            result.setCode(200);
            result.setMsg("登陆成功");
            result.setToken(token);
        } catch (Exception e) {
            result.setCode(444);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @PostMapping("/user/test")
    public JsonResult test(){
        JsonResult result = new JsonResult();
        result.setCode(200);
        result.setMsg("认证成功");
        return result;
    }

}
