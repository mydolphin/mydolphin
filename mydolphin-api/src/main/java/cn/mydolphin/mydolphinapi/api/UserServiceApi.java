package cn.mydolphin.mydolphinapi.api;

public interface UserServiceApi {

    boolean login(String userName, String passWd);

    boolean register(UserVo userVo);

    boolean validateUserName(String userName);

    UserInfoVo getUserInfo(int uId);

    UserInfoVo updUserInfo(UserInfoVo userInfoVo);


}
