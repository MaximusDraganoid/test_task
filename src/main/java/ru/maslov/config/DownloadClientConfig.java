package ru.maslov.config;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.maslov.clients.DownloadClient;

@Configuration
public class DownloadClientConfig {
    @Bean
    DownloadClient downloadClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(DownloadClient.class, "");
    }
}
