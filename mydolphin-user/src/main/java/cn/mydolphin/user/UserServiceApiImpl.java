package cn.mydolphin.user;

import cn.mydolphin.mydolphinapi.api.UserInfoVo;
import cn.mydolphin.mydolphinapi.api.UserServiceApi;
import cn.mydolphin.mydolphinapi.api.UserVo;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserServiceApi.class)
public class UserServiceApiImpl implements UserServiceApi {
    @Override
    public int login(String userName, String passWd) {
        return 0;
    }

    @Override
    public boolean register(UserVo userVo) {
        return false;
    }

    @Override
    public boolean validateUserName(String userName) {
        return false;
    }

    @Override
    public UserInfoVo getUserInfo(int uId) {
        return null;
    }

    @Override
    public UserInfoVo updUserInfo(UserInfoVo userInfoVo) {
        return null;
    }
}
