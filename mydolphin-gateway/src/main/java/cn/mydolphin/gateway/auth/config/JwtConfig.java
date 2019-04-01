package cn.mydolphin.gateway.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = JwtConfig.JWT_PREFIX)
@Configuration
public class JwtConfig {
    static final String JWT_PREFIX = "jwt";

    @Value("${auth-ignore-url}")
    private String authIgnoreUrl = "";

    public String getAuthIgnoreUrl() {
        return authIgnoreUrl;
    }

    public void setAuthIgnoreUrl(String authIgnoreUrl) {
        this.authIgnoreUrl = authIgnoreUrl;
    }
}
