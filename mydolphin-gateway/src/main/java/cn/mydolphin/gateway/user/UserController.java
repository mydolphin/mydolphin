package cn.mydolphin.gateway.user;

import cn.mydolphin.gateway.common.CurUser;
import cn.mydolphin.mydolphinapi.api.UserInfoVo;
import cn.mydolphin.mydolphinapi.api.UserServiceApi;
import cn.mydolphin.mydolphinapi.api.UserVo;
import com.alibaba.dubbo.config.annotation.Reference;
import com.mydolphin.common.domain.ResResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(interfaceClass = UserServiceApi.class)
    private UserServiceApi userServiceApi;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResResult register(UserVo userVo) {
        if(StringUtils.isEmpty(userVo.getUserName())) {
            return ResResult.fail("用户名不能为空!");
        }
        if(StringUtils.isEmpty(userVo.getPassWd())) {
            return ResResult.fail("密码不能为空!");
        }
        boolean register = userServiceApi.register(userVo);
        if(register) {
            return ResResult.success("注册成功!");
        }else {
            return ResResult.fail("注册失败!");
        }
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ResResult validate(String userName) {
        if(StringUtils.isEmpty(userName)) {
            return ResResult.fail("用户名不能为空!");
        }
        boolean validateUserName = userServiceApi.validateUserName(userName);
        if(!validateUserName) {
            return ResResult.fail("用户名不存在!");
        }else {
            return ResResult.success("用户名已存在!");
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResResult logout() {
        return null;
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public ResResult getUserInfo() {
        //获取登录用户
        String userId = CurUser.getCurUser();
        if(!StringUtils.isEmpty(userId)) {
            int uId = Integer.parseInt(userId);
            UserInfoVo userInfo = userServiceApi.getUserInfo(uId);
            if(userInfo!=null) {
                return ResResult.success(userInfo);
            }else {
                return ResResult.fail("用户查询失败");
            }

        }else {
            return ResResult.fail("用户未登录");
        }
    }

    @RequestMapping(value = "/updUserInfo", method = RequestMethod.POST)
    public ResResult updUserInfo(UserInfoVo userInfoVo) {
        //获取登录用户
        String userId = CurUser.getCurUser();
        if(!StringUtils.isEmpty(userId)) {
            int uId = Integer.parseInt(userId);
            if(uId != userInfoVo.getUserId()){
                return ResResult.fail("请修改您个人的用户信息!");
            }
            UserInfoVo userInfo = userServiceApi.updUserInfo(userInfoVo);
            if(userInfo!=null) {
                return ResResult.success(userInfo);
            }else {
                return ResResult.fail("修改失败");
            }
        }else {
            return ResResult.fail("未登录");
        }
    }


}
