package com.br.jeiferson.urlshortenerchallenge.service;

import com.br.jeiferson.urlshortenerchallenge.entity.ShortenedURLEntity;
import com.br.jeiferson.urlshortenerchallenge.repository.ShortenerRepository;
import com.br.jeiferson.urlshortenerchallenge.util.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ShortenerService {

  @Autowired
  private RandomService randomService;

  @Autowired
  private ShortenerRepository shortenerRepository;
  @Autowired
  private CacheService cacheService;

  public String shortUrl(String url) {
    String shortUrl = getValidShortUrl();

    ShortenedURLEntity shortenedURLEntity = new ShortenedURLEntity()
        .originalUrl(url).shortenedUrl(shortUrl);
    shortenerRepository.save(shortenedURLEntity);

    return shortUrl;
  }

  public Optional<String> exchangeUrl(String url) {
    if (Environment.isCacheEnabled()) {
      Optional<Object> cachedUrl = cacheService.get(url);
      if (cachedUrl.isPresent()) {
        return Optional.of((String) cachedUrl.get());
      }
    }
    Optional<ShortenedURLEntity> shortenedURL = shortenerRepository.findByShortenedUrl(url);
    if (Environment.isCacheEnabled()
        && cacheService.getCurrentCacheSize() < Environment.getMaxCacheSize()
        && shortenedURL.isPresent()) {
      cacheService.set(url, shortenedURL.get().getOriginalUrl());
    }
    return shortenedURL.map(ShortenedURLEntity::getOriginalUrl);
  }

  private String getValidShortUrl() {
    String shortUrl = randomService.generateRandomString(Environment.getShortUrlLength());

    Optional<ShortenedURLEntity> optionalShortenedURLEntity;
    do {
      optionalShortenedURLEntity = shortenerRepository.findByShortenedUrl(shortUrl);
    } while (optionalShortenedURLEntity.isPresent());

    return shortUrl;
  }
}
