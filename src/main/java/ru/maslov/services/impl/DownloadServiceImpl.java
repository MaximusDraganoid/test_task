package ru.maslov.services.impl;

import org.springframework.stereotype.Service;
import ru.maslov.clients.DownloadClient;
import ru.maslov.services.DownloadService;

@Service
public class DownloadServiceImpl implements DownloadService {

    private final DownloadClient downloadClient;

    public DownloadServiceImpl(DownloadClient downloadClient) {
        this.downloadClient = downloadClient;
    }

    @Override
    public byte[] getGifByUrl(String url) {
        return downloadClient.getGifByUrl(url);
    }
}
