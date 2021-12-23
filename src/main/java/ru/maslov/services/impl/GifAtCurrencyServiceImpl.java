package ru.maslov.services.impl;

import org.springframework.stereotype.Service;
import ru.maslov.dto.GifDTO;
import ru.maslov.services.CurrencyService;
import ru.maslov.services.DownloadService;
import ru.maslov.services.GifAtCurrencyService;
import ru.maslov.services.GifService;

import java.util.Map;

@Service
public class GifAtCurrencyServiceImpl implements GifAtCurrencyService {

    private static final String BROKE = "broke";
    private static final String RICH = "rich";
    private static final String IMAGE = "images";


    private final CurrencyService currencyService;

    private final GifService gifService;


    public GifAtCurrencyServiceImpl(CurrencyService currencyService,
                                    GifService gifService) {
        this.currencyService = currencyService;
        this.gifService = gifService;
    }

    @Override
    public String getGifByCurrency() {
        GifDTO resultOfRequest;
        if (currencyService.isTodayValueMoreThanYesterdayValue()) {
            resultOfRequest = gifService.getGif(RICH);
        } else {
            resultOfRequest = gifService.getGif(BROKE);
        }

        return getDownLoadUrlFromGifDTO(resultOfRequest);
    }


    private String getDownLoadUrlFromGifDTO(GifDTO gifDTO) {
        return gifDTO.getData().get("embed_url").toString();
    }
}
