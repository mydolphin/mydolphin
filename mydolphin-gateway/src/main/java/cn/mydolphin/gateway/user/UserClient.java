package cn.mydolphin.gateway.user;

import cn.mydolphin.mydolphinapi.api.UserServiceApi;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class UserClient {

    @Reference(interfaceClass = UserServiceApi.class)
    UserServiceApi userServiceApi;

    public void run() {
        userServiceApi.login("admin", "admin");
    }
}
