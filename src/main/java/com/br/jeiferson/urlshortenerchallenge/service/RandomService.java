package com.br.jeiferson.urlshortenerchallenge.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomService {

  public final String chars = "abcdefjhijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ0123456789";

  public String generateRandomString(int length) {
    Random random = new Random();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < length; i++) {
      builder.append(chars.charAt(random.nextInt(chars.length())));
    }
    return builder.toString();
  }
}
