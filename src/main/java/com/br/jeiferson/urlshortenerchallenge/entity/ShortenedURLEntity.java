package com.br.jeiferson.urlshortenerchallenge.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shortened-url")
public class ShortenedURLEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "original_url")
  private String originalUrl;
  @Column(name = "shortened_url")
  private String shortenedUrl;

  public ShortenedURLEntity originalUrl(String url) {
    this.originalUrl = url;
    return this;
  }

  public ShortenedURLEntity shortenedUrl(String shortenedUrl) {
    this.shortenedUrl = shortenedUrl;
    return this;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOriginalUrl() {
    return originalUrl;
  }

  public void setOriginalUrl(String originalUrl) {
    this.originalUrl = originalUrl;
  }

  public String getShortenedUrl() {
    return shortenedUrl;
  }

  public void setShortenedUrl(String shortenedUrl) {
    this.shortenedUrl = shortenedUrl;
  }
}
