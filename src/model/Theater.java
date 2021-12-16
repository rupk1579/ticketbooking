package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Theater {

    private List<Screen> screens;
    private String id;

    public Theater(List<Screen> screens) {
        this.screens = screens;
        id= UUID.randomUUID().toString();
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public String getId() {
        return id;
    }

}
