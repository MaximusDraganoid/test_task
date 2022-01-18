package ru.maslov.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maslov.services.GifAtCurrencyService;

@Controller
public class CurrencyCheckController {

    public static final Logger logger = LoggerFactory.getLogger(CurrencyCheckController.class);

    private final GifAtCurrencyService gifAtCurrencyService;

    public CurrencyCheckController(GifAtCurrencyService gifAtCurrencyService) {
        logger.info("init of currency check controller bean");
        this.gifAtCurrencyService = gifAtCurrencyService;
    }



    @GetMapping("/gif_by_currency")
    public String getGifByCurrency(Model model) {
        logger.debug("starting process query /gif_by_currency");

        String embedUrl = gifAtCurrencyService.getGifByCurrency();
        model.addAttribute("embedUrl", embedUrl);
        logger.info("end of processing query /gif_by_currency");
        return "index";
    }
}
