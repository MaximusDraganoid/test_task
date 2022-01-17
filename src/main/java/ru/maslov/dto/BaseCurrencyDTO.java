package ru.maslov.dto;

public class BaseCurrencyDTO {
    private String disclaimer;
    private String license;


    public BaseCurrencyDTO() {
    }

    public BaseCurrencyDTO(String disclaimer, String license) {
        this.disclaimer = disclaimer;
        this.license = license;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
