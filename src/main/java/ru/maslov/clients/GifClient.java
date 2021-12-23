package ru.maslov.clients;

import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maslov.dto.GifDTO;

public interface GifClient {
    @RequestLine("GET /")
    GifDTO getGif(@RequestParam(name = "api_key") String apiKey,
                  @RequestParam(name = "tag") String tag);
}
