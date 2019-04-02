package cn.mydolphin.gateway.common;


public class CurUser {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setCurUserId(String userId) {
        threadLocal.set(userId);
    }

    public static String getCurUser() {
        return threadLocal.get();
    }
}
