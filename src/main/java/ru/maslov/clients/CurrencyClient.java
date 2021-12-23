package ru.maslov.clients;

import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maslov.dto.CurrencyDTO;

public interface CurrencyClient {
    @RequestLine("GET /{data}.json")
    CurrencyDTO getCurrency(@Param("date") String date,
                            @RequestParam(name = "app_id"   ) String appId,
                            @RequestParam(name = "symbols") String symbols);
}
