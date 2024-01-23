package com.br.jeiferson.urlshortenerchallenge.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CacheService {

  public final Map<String, Object> cachedObjects = new LinkedHashMap<>();

  public Optional<Object> get(String key) {
    return Optional.ofNullable(cachedObjects.get(key));
  }

  public void set(String key, Object object) {
    cachedObjects.put(key, object);
  }

  public int getCurrentCacheSize() {
    return cachedObjects.size();
  }

}
