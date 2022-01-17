package ru.maslov.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maslov.dto.CurrencyDTO;
import ru.maslov.dto.CurrencyPeriodDTO;

@FeignClient(url = "${currency.url}", name = "currencyClient")
public interface CurrencyClient {
    @RequestMapping(method = RequestMethod.GET, value = "/historical/{date}.json")
    CurrencyDTO getCurrency(@PathVariable("date") String date,
                            @RequestParam(name = "app_id") String appId,
                            @RequestParam(name = "symbols") String symbols);
//    ONLY FOR ENTERPRISE
//    @RequestMapping(method = RequestMethod.GET, value = "/time-series.json")
//    CurrencyPeriodDTO getPeriodOfCurrency(@RequestParam(name = "app_id") String appId,
//                                          @RequestParam(name = "start") String startDate,
//                                          @RequestParam(name = "end") String endDate,
//                                          @RequestParam(name = "symbols") String symbols);
}
