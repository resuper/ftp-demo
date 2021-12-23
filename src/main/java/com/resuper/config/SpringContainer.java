package com.resuper.config;

import cn.hutool.extra.ftp.Ftp;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sutaotao
 * @date 2021-12-23 10:15
 * @description: TODO
 */
@Configuration
@ConfigurationProperties("custom.ftp")
@Data
public class SpringContainer {
    //    @Value("${custom.ftp.host}")
    private String host;
    //    @Value("${custom.ftp.port}")
    private String port = "21";
    //    @Value("${custom.ftp.username}")
    private String username;
    //    @Value("${custom.ftp.password}")
    private String password;


    @Bean
    public Ftp ftp() {
        return new Ftp(host, Integer.parseInt(port), username, password);
    }
}
