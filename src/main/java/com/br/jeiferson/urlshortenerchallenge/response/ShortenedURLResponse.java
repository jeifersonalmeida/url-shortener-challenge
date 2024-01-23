package com.br.jeiferson.urlshortenerchallenge.response;

public class ShortenedURLResponse {

  public String url;

  public ShortenedURLResponse url(String url) {
    this.url = url;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
