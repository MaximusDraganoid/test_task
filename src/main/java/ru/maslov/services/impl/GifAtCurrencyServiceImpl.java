package ru.maslov.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.maslov.dto.GifDTO;
import ru.maslov.services.CurrencyService;
import ru.maslov.services.DownloadService;
import ru.maslov.services.GifAtCurrencyService;
import ru.maslov.services.GifService;

import java.util.Map;

@Service
public class GifAtCurrencyServiceImpl implements GifAtCurrencyService {

    private final String broke;
    private final String rich;
    private final String embedUrl;


    private final CurrencyService currencyService;

    private final GifService gifService;


    public GifAtCurrencyServiceImpl(CurrencyService currencyService,
                                    GifService gifService,
                                    @Value("${giphy.rich}") String rich,
                                    @Value("${giphy.broke}") String broke,
                                    @Value("${giphy.embed.url}") String embedUrl) {
        this.currencyService = currencyService;
        this.gifService = gifService;
        this.rich = rich;
        this.broke = broke;
        this.embedUrl=embedUrl;
    }

    @Override
    public String getGifByCurrency() {
        GifDTO resultOfRequest;
        if (currencyService.isTodayValueMoreThanYesterdayValue()) {
            resultOfRequest = gifService.getGif(rich);
        } else {
            resultOfRequest = gifService.getGif(broke);
        }

        return getDownLoadUrlFromGifDTO(resultOfRequest);
    }


    private String getDownLoadUrlFromGifDTO(GifDTO gifDTO) {
        return gifDTO.getData().get(embedUrl).toString();
    }
}
