package model;

import enums.SEATSTATUS;
import enums.SEATTYPE;

public class Seat {

    private SEATSTATUS seatstatus;
    private Integer seatNumber;
    private SEATTYPE type;

    public Seat(SEATSTATUS seatstatus, Integer seatNumber, SEATTYPE type) {
        this.seatstatus = seatstatus;
        this.seatNumber = seatNumber;
        this.type = type;
    }

    public SEATSTATUS getSeatstatus() {
        return seatstatus;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public SEATTYPE getType() {
        return type;
    }

    public void setSeatstatus(SEATSTATUS seatstatus) {
        this.seatstatus = seatstatus;
    }
}
