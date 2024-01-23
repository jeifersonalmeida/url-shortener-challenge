package com.br.jeiferson.urlshortenerchallenge.util;

import java.util.Optional;

public class Environment {

  private static final int SHORT_URL_LENGTH_DEFAULT = 7;
  private static final boolean ENABLE_CACHE_DEFAULT = false;
  private static final int MAX_CACHE_SIZE_DEFAULT = 1000;

  public static int getShortUrlLength() {
    String shortUrlLength = System.getenv("SHORT_URL_LENGTH");
    return shortUrlLength != null ? Integer.parseInt(shortUrlLength) : SHORT_URL_LENGTH_DEFAULT;
  }

  public static boolean isCacheEnabled() {
    String enableCache = System.getenv("ENABLE_CACHE");
    return enableCache != null ? Boolean.parseBoolean(enableCache) : ENABLE_CACHE_DEFAULT;
  }

  public static int getMaxCacheSize() {
    String maxCacheSize = System.getenv("MAX_CACHE_SIZE");
    return maxCacheSize != null ? Integer.parseInt(maxCacheSize) : MAX_CACHE_SIZE_DEFAULT;
  }
}
