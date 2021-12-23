package ru.maslov.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.maslov.clients.CurrencyClient;
import ru.maslov.dto.CurrencyDTO;
import ru.maslov.services.CurrencyService;

import java.time.LocalDate;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyClient currencyClient;

    private String appId;

    private String currency;

    public CurrencyServiceImpl(CurrencyClient currencyClient,
                               @Value("${openexchangerates.app.id}") String appId,
                               @Value("${currency}") String currency) {
        this.currencyClient = currencyClient;
        this.appId = appId;
        this.currency = currency;
    }

    @Override
    public boolean isTodayValueMoreThanYesterdayValue() {
        CurrencyDTO todayCurrency = getCurrencyByDate(LocalDate.now());
        CurrencyDTO yesterdayCurrency = getCurrencyByDate(LocalDate.now().minusDays(1L));
        return todayCurrency.getRates().get(currency)
                .compareTo(yesterdayCurrency.getRates().get(currency)) > 0;
    }

    private CurrencyDTO getCurrencyByDate(LocalDate date) {
        return currencyClient.getCurrency(date.toString(), appId, currency);
    }
}
