package ru.maslov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maslov.services.GifAtCurrencyService;

@Controller
public class CurrencyCheckController {

    private final GifAtCurrencyService gifAtCurrencyService;

    public CurrencyCheckController(GifAtCurrencyService gifAtCurrencyService) {
        this.gifAtCurrencyService = gifAtCurrencyService;
    }



    @GetMapping("/gif_by_currency")
    public String getGifByCurrency(Model model) {
        String embedUrl = gifAtCurrencyService.getGifByCurrency();
        model.addAttribute("embedUrl", embedUrl);
        return "index";
    }
}
