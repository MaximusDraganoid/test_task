package ru.maslov.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maslov.services.GifAtCurrencyService;

@RestController
@RequestMapping("/api")
public class CurrencyCheckController {

    private final GifAtCurrencyService gifAtCurrencyService;

    public CurrencyCheckController(GifAtCurrencyService gifAtCurrencyService) {
        this.gifAtCurrencyService = gifAtCurrencyService;
    }

    @GetMapping("/gif_by_currency")
    public void getGif() {
        gifAtCurrencyService.getGifByCurrency();
    }
}
