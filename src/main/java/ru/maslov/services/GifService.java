package ru.maslov.services;

import ru.maslov.dto.GifDTO;

public interface GifService {
    GifDTO getGif(String tag);
}
