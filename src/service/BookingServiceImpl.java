package service;

import enums.SEATSTATUS;
import exception.BookingServiceException;
import model.Seat;
import model.Show;

import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {


    TheaterAdminService theaterAdminService = TheaterAdminService.getInstance();


    @Override
    public List<Seat> getAllAvailableSeats(Show show) {
        return TheaterAdminService.getStringShowMap().get(show.getShowId()).getSeats()
                .stream()
                .filter(seat -> seat.getSeatstatus().equals(SEATSTATUS.AVAILABLE))
                .collect(Collectors.toList());
    }

    @Override
    public synchronized String BlockSeat(List<Seat> seats, Show show) {
       TheaterAdminService.getStringShowMap().get(show.getShowId()).getSeats()
               .forEach(seat -> {
                   if(!seat.getSeatstatus().equals(SEATSTATUS.AVAILABLE))
                       throw  new BookingServiceException("Seat is not Available,please try again");
                   seat.setSeatstatus(SEATSTATUS.TEMPORARY_UNAVAILABLE);
               });
       return "SUCCESS";
    }

    @Override
    public String updateSeatStatus(List<Seat> seats, Show show) {
        TheaterAdminService.getStringShowMap().get(show.getShowId())
                .getSeats().forEach(seat -> {
                    seat.setSeatstatus(SEATSTATUS.PERMANENT_UNAVAILABLE);
        });
        return "SUCCESS";
    }
}
