package ru.maslov.services.impl;

import org.springframework.beans.factory.annotation.Value;
import ru.maslov.clients.GifClient;
import ru.maslov.dto.GifDTO;

public class GifServiceImpl implements ru.maslov.services.GifService {

    @Value("${giphy.api.key}")
    private String apiKey;

    private final GifClient gifClient;

    public GifServiceImpl(GifClient gifClient) {
        this.gifClient = gifClient;
    }

    @Override
    public GifDTO getGif(String tag) {
        return gifClient.getGif(apiKey, tag);
    }
}
