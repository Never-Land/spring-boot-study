package com.spring.boot.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 演示@ConfigurationProperties注解的配置实体
 */
@NoArgsConstructor
@Setter
@Getter
@ToString
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorConfig {
    /**
     * 姓名
     */
    private String name;
    /**
     * 业余爱好
     */
    private String hobby;
}
