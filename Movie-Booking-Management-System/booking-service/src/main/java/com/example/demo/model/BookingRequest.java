package com.example.demo.model;


public class BookingRequest {

    private int movieId;
    private int tickets;

    public BookingRequest() {}

    public BookingRequest(int movieId, int tickets) {
        this.movieId = movieId;
        this.tickets = tickets;
    }

    public int getMovieId() { return movieId; }
    public void setMovieId(int movieId) { this.movieId = movieId; }

    public int getTickets() { return tickets; }
    public void setTickets(int tickets) { this.tickets = tickets; }
}