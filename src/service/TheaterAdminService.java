package service;

import model.Screen;
import model.Seat;
import model.Show;
import model.Theater;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterAdminService {

    private static TheaterAdminService instance = null;
    private static Map<String, Theater> theaterMap = new HashMap<>();
    private static Map<String, Screen> stringScreenMap = new HashMap<>();
    private static Map<String, Show> stringShowMap = new HashMap<>();

    public static TheaterAdminService getInstance() {
        if (instance != null) return instance;

        synchronized (TheaterAdminService.class) {
            if (instance == null) {
                instance = new TheaterAdminService();
            }
            return instance;
        }
    }

    private TheaterAdminService() {

    }

    public void addTheater(Theater theater) {
        theaterMap.put(theater.getId(), theater);
        addScreen(theater.getScreens(), theater);
    }

    public void addSeat(List<Seat> seats, Show show) {
        stringShowMap.get(show.getShowId()).getSeats().addAll(seats);
    }

    public void addScreen(List<Screen> screens, Theater theater) {
        theaterMap.get(theater.getId()).getScreens().addAll(screens);
        screens.forEach(screen -> {
            stringScreenMap.put(screen.getId(), screen);
            addShow(screen.getShows(), screen);

        });

    }

    public void addShow(List<Show> shows, Screen screen) {
        stringScreenMap.get(screen.getId()).getShows().addAll(shows);
        shows.forEach(show -> {
            stringShowMap.put(show.getShowId(), show);
            addSeat(show.getSeats(), show);
        });
    }

    public static Map<String, Theater> getTheaterMap() {
        return theaterMap;
    }

    public static Map<String, Screen> getStringScreenMap() {
        return stringScreenMap;
    }

    public static Map<String, Show> getStringShowMap() {
        return stringShowMap;
    }
}
