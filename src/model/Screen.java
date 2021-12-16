package model;

import java.util.List;
import java.util.UUID;

public class Screen {

    private String id;
    private List<Show> shows;

    public Screen(List<Show> shows) {

        this.shows = shows;
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }


    public List<Show> getShows() {
        return shows;
    }
}
