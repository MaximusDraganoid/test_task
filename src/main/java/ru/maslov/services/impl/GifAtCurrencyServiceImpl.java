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

    private final DownloadService downloadService;

    public GifAtCurrencyServiceImpl(CurrencyService currencyService,
                                    GifService gifService,
                                    DownloadService downloadService) {
        this.currencyService = currencyService;
        this.gifService = gifService;
        this.downloadService = downloadService;
    }

    @Override
    public void getGifByCurrency() {
        GifDTO resultOfRequest;
        if (currencyService.isTodayValueMoreThanYesterdayValue()) {
            resultOfRequest = gifService.getGif(RICH);
        } else {
            resultOfRequest = gifService.getGif(BROKE);
        }

        String downloadUrl = getDownLoadUrlFromGifDTO(resultOfRequest);

        System.out.println(downloadUrl);


    }


    private String getDownLoadUrlFromGifDTO(GifDTO gifDTO) {
        Map<String, Object> imagesData = (Map<String, Object>) gifDTO.getData().get("images");
        Map<String ,String> originalGifData = (Map<String, String>) imagesData.get("original");
        return originalGifData.get("mp4");
    }
}
