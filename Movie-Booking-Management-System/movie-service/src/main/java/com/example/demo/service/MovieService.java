package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;

@Service
public class MovieService {

    private final Map<Integer, Movie> movieStore = new HashMap<>();

    public MovieService() {
        movieStore.put(1, new Movie(1, "Inception", "English", 250));
        movieStore.put(2, new Movie(2, "RRR", "Telugu", 200));
        movieStore.put(3, new Movie(3, "Dangal", "Hindi", 180));
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movieStore.values());
    }

    public Optional<Movie> getMovieById(int id) {
        return Optional.ofNullable(movieStore.get(id));
    }
}