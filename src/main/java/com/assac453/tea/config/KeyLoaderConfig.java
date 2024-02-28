package com.assac453.tea.config;

import com.assac453.tea.file.KeyLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeyLoaderConfig {
    @Bean
    public KeyLoader keyLoader(){
        return new KeyLoader();
    }
}
