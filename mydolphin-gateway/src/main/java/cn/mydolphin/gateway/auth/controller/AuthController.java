package cn.mydolphin.gateway.auth.controller;

import cn.mydolphin.gateway.auth.domain.AuthReq;
import cn.mydolphin.mydolphinapi.api.UserServiceApi;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mydolphin.common.domain.ResResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @Reference(interfaceClass = UserServiceApi.class)
    private UserServiceApi userServiceApi;


    @RequestMapping(value = "${jwt.auth-url}")
    public ResResult authToken(AuthReq authReq) {
        boolean isLogined = false;
        int uId = userServiceApi.login(authReq.getUserName(), authReq.getPassWd());
        if(uId != 0) {
            isLogined = true;
        }

        if(isLogined) {
            return ResResult.success("");
        }else {
            return ResResult.fail("用户名或密码错误!");
        }

    }


}
