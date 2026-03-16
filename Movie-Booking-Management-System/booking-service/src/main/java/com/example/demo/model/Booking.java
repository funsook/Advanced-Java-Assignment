package com.example.demo.model;


public class Booking {

    private int bookingId;
    private int movieId;
    private String movieName;
    private int tickets;
    private double totalAmount;
    private String status;

    public Booking() {}

    public Booking(int bookingId, int movieId, String movieName,
                   int tickets, double totalAmount, String status) {
        this.bookingId = bookingId;
        this.movieId = movieId;
        this.movieName = movieName;
        this.tickets = tickets;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public int getMovieId() { return movieId; }
    public void setMovieId(int movieId) { this.movieId = movieId; }

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public int getTickets() { return tickets; }
    public void setTickets(int tickets) { this.tickets = tickets; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
