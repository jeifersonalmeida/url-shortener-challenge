package com.br.jeiferson.urlshortenerchallenge.controller;

import com.br.jeiferson.urlshortenerchallenge.dto.ShortUrlDTO;
import com.br.jeiferson.urlshortenerchallenge.response.ShortenedURLResponse;
import com.br.jeiferson.urlshortenerchallenge.service.ShortenerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ShortenerController {

  @Autowired
  private ShortenerService shortenerService;

  @GetMapping("/{url}")
  public ResponseEntity<ShortenedURLResponse> exchangeUrl(@PathVariable String url, HttpServletResponse response) throws IOException {
    Optional<String> optionalRedirectUrl = shortenerService.exchangeUrl(url);
    if (optionalRedirectUrl.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    String redirectUrl = optionalRedirectUrl.get();
    if (!redirectUrl.startsWith("http")) {
      redirectUrl = "https://".concat(redirectUrl);
    }
//    response.sendRedirect(redirectUrl);

    return ResponseEntity.ok(new ShortenedURLResponse().url(redirectUrl));
  }

  @PostMapping("/")
  public ResponseEntity<ShortenedURLResponse> shortUrl(@RequestBody ShortUrlDTO shortUrlDTO) {
    String shortUrl = shortenerService.shortUrl(shortUrlDTO.getUrlToShort());
    return ResponseEntity.ok(new ShortenedURLResponse().url(shortUrl));
  }
}
