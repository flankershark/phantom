package ac.phantom.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ron on 2/5/17.
 */

public class Dish {
    public int id;
    public String title;
    public String desc;
    public int image;
    public List<Restriction> restrictions;
    public Restaurant restaurant;

    public Dish(int id, String title, String desc, int image, Restaurant restaurant) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.restrictions = new ArrayList<>();
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.title, this.desc, this.restaurant);
    }
}

//:)~
