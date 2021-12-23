package ru.maslov.services;

import org.springframework.stereotype.Service;

@Service
public interface CurrencyService {

    boolean isTodayValueMoreThanYesterdayValue();
}
