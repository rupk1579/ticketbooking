package service;

import model.Seat;
import model.Show;

import java.util.List;

public interface BookingService {

    public List<Seat> getAllAvailableSeats(Show show);

    public String BlockSeat(List<Seat> seats,Show show);

    public String updateSeatStatus(List<Seat> seats,Show show);



}
