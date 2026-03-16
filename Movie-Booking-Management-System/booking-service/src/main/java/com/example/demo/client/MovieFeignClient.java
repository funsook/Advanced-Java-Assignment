package com.example.demo.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Movie;

@FeignClient(name = "movie-service")
public interface MovieFeignClient {

    @GetMapping("/movies/{id}")
    Movie getMovieById(@PathVariable("id") int id);
}