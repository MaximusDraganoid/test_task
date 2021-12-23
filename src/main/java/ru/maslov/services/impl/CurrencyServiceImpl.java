package ru.maslov.services.impl;

import org.springframework.beans.factory.annotation.Value;
import ru.maslov.clients.CurrencyClient;
import ru.maslov.dto.CurrencyDTO;
import ru.maslov.services.CurrencyService;

import java.time.LocalDate;

public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyClient currencyClient;

    @Value("${openexchangerates.app.id}")
    private String appId;

    @Value("${currency}")
    private String currency;

    public CurrencyServiceImpl(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    @Override
    public boolean isYesterdayValueMoreThanTodayValue() {
        CurrencyDTO todayCurrency = getCurrencyByDate(LocalDate.now());
        CurrencyDTO yesterdayCurrency = getCurrencyByDate(LocalDate.now().minusDays(1L));
        return todayCurrency.getRates().get(currency)
                .compareTo(yesterdayCurrency.getRates().get(currency)) > 0;
    }

    private CurrencyDTO getCurrencyByDate(LocalDate date) {
        return currencyClient.getCurrency(date.toString(), appId, currency);
    }
}
