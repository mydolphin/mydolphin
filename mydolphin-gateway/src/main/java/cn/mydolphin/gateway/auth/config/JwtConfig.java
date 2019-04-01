package cn.mydolphin.gateway.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = JwtConfig.JWT_PREFIX)
public class JwtConfig {
    public static final String JWT_PREFIX = "jwt";
    private String noAuthUrl = "";

    public String getNoAuthUrl() {
        return noAuthUrl;
    }

    public void setNoAuthUrl(String noAuthUrl) {
        this.noAuthUrl = noAuthUrl;
    }
}
