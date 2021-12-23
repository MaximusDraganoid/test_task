package ru.maslov.config;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import ru.maslov.clients.CurrencyClient;

public class ClientConfig {

    @Value("${currency.url}")
    private String baseCurrencyUrl;

    @Bean
    public CurrencyClient currencyClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CurrencyClient.class, baseCurrencyUrl);
    }
}
