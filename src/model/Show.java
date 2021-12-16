package model;

import java.util.List;

public class Show {

    private  String showId;
    private double duration;
    private String startTime;
    private String endTime;
    private Movie movie;
    private List<Seat> seats;

    public Show(double duration, String startTime, String endTime, Movie movie, List<Seat> seats) {
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
        this.seats = seats;
    }

    public String getShowId() {
        return showId;
    }

    public double getDuration() {
        return duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
