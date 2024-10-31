package com.maids.test.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
//
@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        // Create the HTTP request factory with timeout settings
        // HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(5000);  // Connection timeout in milliseconds
        factory.setReadTimeout(5000);     // Read timeout in milliseconds
        return new RestTemplate(factory);
    }
    
}
