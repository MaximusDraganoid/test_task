package ru.maslov.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "downloadClient", url = "https://placeholder")
public interface DownloadClient {
    @RequestMapping(method = RequestMethod.GET, value = "{url}")
    byte[] getGifByUrl(@PathVariable("url") String url);
}
