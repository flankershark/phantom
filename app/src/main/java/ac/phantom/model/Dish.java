package ac.phantom.model;

/**
 * Created by runo on 2/5/17.
 */

public class Dish {
    public int id;
    public String title;
    public String desc;
    public int image;
    public String dr; // dietary restrictions
    public Restaurant restaurant;

    public Dish(int id, String title, String desc, int image, String dr, Restaurant restaurant) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.dr = dr;
        this.restaurant = restaurant;
    }
}

//:)~
