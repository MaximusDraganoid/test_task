package ru.maslov.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import ru.maslov.services.GifAtCurrencyService;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:testing.properties")
class CurrencyCheckControllerTest {

    @Value("${embed.url}")
    private String embedUrl;

    @Value("${testing.route}")
    private String testingRoute;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GifAtCurrencyService gifAtCurrencyService;

    @Test
    void canGetGifByCurrency() throws Exception {
        //given
        Mockito.doReturn(embedUrl)
                .when(gifAtCurrencyService)
                .getGifByCurrency();
        //when
        //then
        mockMvc.perform(get(testingRoute))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(content().string(containsString("<embed src=\"" + embedUrl + "\">")));
        verify(gifAtCurrencyService).getGifByCurrency();
    }
}