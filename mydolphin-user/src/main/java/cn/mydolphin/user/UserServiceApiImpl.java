package cn.mydolphin.user;

import cn.mydolphin.mydolphinapi.api.UserServiceApi;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserServiceApi.class)
public class UserServiceApiImpl implements UserServiceApi {
    @Override
    public boolean login(String userName, String passWd) {
        return false;
    }
}
