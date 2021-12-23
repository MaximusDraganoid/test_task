package ru.maslov.clients;

import feign.Param;
import feign.RequestLine;

public interface DownloadClient {
    @RequestLine("GET {url}")
    byte[] getGifByUrl(@Param("url") String url);
}
