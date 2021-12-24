package ru.maslov.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import ru.maslov.dto.GifDTO;
import ru.maslov.services.CurrencyService;
import ru.maslov.services.GifAtCurrencyService;
import ru.maslov.services.GifService;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@SpringBootTest
@TestPropertySource("classpath:testing.properties")
class GifAtCurrencyServiceImplTest {

    GifAtCurrencyService gifAtCurrencyService;

    @MockBean
    CurrencyService currencyService;

    @MockBean
    GifService gifService;

    @Value("${giphy.rich}")
    private String rich;

    @Value("${giphy.broke}")
    private String broke;

    @Value("${giphy.embed.url}")
    private String embedUrl;

    @Value("${embed.url}")
    private String testEmbedUrl;

    private GifDTO gifDTO;

    @BeforeEach
    void setUp() {
        gifAtCurrencyService = new GifAtCurrencyServiceImpl(currencyService, gifService, rich, broke, embedUrl);
    }

    @Test
    void getGifByCurrencyWhenTodayIsMoreThanYesterday() {
        //given
        GifDTO testGifDTO = initGifDto();

        Mockito.doReturn(true)
                .when(currencyService)
                .isTodayValueMoreThanYesterdayValue();

        Mockito.doReturn(testGifDTO)
                .when(gifService)
                .getGif(rich);
        //when
        String resultUrl = gifAtCurrencyService.getGifByCurrency();
        //then
        verify(currencyService).isTodayValueMoreThanYesterdayValue();
        verify(gifService).getGif(rich);
        verify(gifService, never()).getGif(broke);
        assertThat(resultUrl).isEqualTo(testEmbedUrl);
    }

    @Test
    void getGifByCurrencyWhenTodayIsLessOrEqualYesterday() {
        //given
        GifDTO testGifDTO = initGifDto();

        Mockito.doReturn(false)
                .when(currencyService)
                .isTodayValueMoreThanYesterdayValue();

        Mockito.doReturn(testGifDTO)
                .when(gifService)
                .getGif(broke);
        //when
        String resultUrl = gifAtCurrencyService.getGifByCurrency();

        //then
        verify(currencyService).isTodayValueMoreThanYesterdayValue();
        verify(gifService).getGif(broke);
        verify(gifService, never()).getGif(rich );
        assertThat(resultUrl).isEqualTo(testEmbedUrl);
    }

    private GifDTO initGifDto() {
        GifDTO gifDTO = new GifDTO();
        Map<String, Object> map = new HashMap<>();
        map.put(embedUrl, testEmbedUrl);
        gifDTO.setData(map);
        return gifDTO;
    }
}