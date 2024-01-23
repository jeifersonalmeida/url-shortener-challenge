package com.br.jeiferson.urlshortenerchallenge.repository;

import com.br.jeiferson.urlshortenerchallenge.entity.ShortenedURLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortenerRepository extends JpaRepository<ShortenedURLEntity, Long> {
  Optional<ShortenedURLEntity> findByShortenedUrl(String shortenedUrl);
}
