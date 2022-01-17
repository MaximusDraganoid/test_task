package ru.maslov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CurrencyPeriodDTO extends BaseCurrencyDTO {

    private Map<String, Map<String, Double>> rates;

    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    private String base;

    public CurrencyPeriodDTO() {
    }

    public CurrencyPeriodDTO(String disclaimer,
                             String license, Map<String, Map<String, Double>> rates,
                             String startDate,
                             String endDate,
                             String base) {
        super(disclaimer, license);
        this.rates = rates;
        this.startDate = startDate;
        this.endDate = endDate;
        this.base = base;
    }

    public Map<String, Map<String, Double>> getRates() {
        return rates;
    }

    public void setRates(Map<String, Map<String, Double>> rates) {
        this.rates = rates;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
