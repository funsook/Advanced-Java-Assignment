package com.example.demo.service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.MovieFeignClient;
import com.example.demo.model.Booking;
import com.example.demo.model.BookingRequest;
import com.example.demo.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private MovieFeignClient movieFeignClient;

    private final List<Booking> bookingStore = new ArrayList<>();
    private int bookingIdCounter = 101;

    @CircuitBreaker(name = "movieServiceCB", fallbackMethod = "bookingFallback")
    public Booking createBooking(BookingRequest request) {
        logger.info("Fetching movie details for movieId: {}", request.getMovieId());

        Movie movie = movieFeignClient.getMovieById(request.getMovieId());

        double totalAmount = movie.getPrice() * request.getTickets();

        Booking booking = new Booking(
                bookingIdCounter++,
                movie.getId(),
                movie.getName(),
                request.getTickets(),
                totalAmount,
                "CONFIRMED"
        );

        bookingStore.add(booking);
        logger.info("Booking created: {}", booking.getBookingId());
        return booking;
    }

    public Booking bookingFallback(BookingRequest request, Throwable ex) {
        logger.warn("Circuit breaker triggered! Movie Service is down. Reason: {}", ex.getMessage());

        return new Booking(
                -1,
                request.getMovieId(),
                "UNKNOWN",
                request.getTickets(),
                0.0,
                "FAILED - Movie Service Unavailable"
        );
    }

    public List<Booking> getAllBookings() {
        return bookingStore;
    }
}