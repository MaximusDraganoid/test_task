package ru.maslov.dto;

import java.util.Map;

public class CurrencyDTO extends BaseCurrencyDTO {
    private long timestamp;
    private Map<String, Double> rates;

    public CurrencyDTO() {
    }

    public CurrencyDTO(String disclaimer, String license, long timestamp, Map<String, Double> rates) {
        super(disclaimer, license);
        this.timestamp = timestamp;
        this.rates = rates;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
