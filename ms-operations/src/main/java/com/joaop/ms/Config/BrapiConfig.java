package com.joaop.ms.Config;

import com.joaop.ms.Entities.BrapiProperties;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BrapiConfig {

    private final BrapiProperties brapiProperties;

    @Bean
    public RequestInterceptor brapiRequestInterceptor() {
        return template ->
                template.header("Authorization", "Bearer " + brapiProperties.getToken());
    }

}
