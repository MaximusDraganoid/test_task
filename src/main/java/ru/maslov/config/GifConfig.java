package ru.maslov.config;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.maslov.clients.GifClient;

@Configuration
public class GifConfig {

    @Value("${giphy.url}")
    private String baseGifUrl;

    @Bean
    public GifClient gifClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(GifClient.class, baseGifUrl);
    }
}
