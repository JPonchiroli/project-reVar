package com.joaop.ms.Entities;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "brapi.token")
@Data
@Component
public class BrapiProperties {
    String token;
}
