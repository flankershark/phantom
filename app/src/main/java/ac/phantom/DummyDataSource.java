package ac.phantom;

import java.util.ArrayList;
import java.util.List;

import ac.phantom.model.Dish;
import ac.phantom.model.Restaurant;
import ac.phantom.model.User;

/**
 * Created by ron on 2/5/17.
 */

public class DummyDataSource {
    private static List<User> users = null;                  // user list (table)
    private static List<Restaurant> restaurants = null;      // restaurant list (table)
    private static List<Dish> dishes = null;                 // dish list (table)

    static {
        // constructs a couple of users
        users = new ArrayList<>();
        users.add(new User(1, "alice@ac.com", "123456"));
        users.add(new User(2, "bob@ac.com", "654321"));

        // creates a few restaurants
        restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1, "McDonald's", "1380 Collage Square, Ottawa, ON", "+1 (613) 255-0000"));
        restaurants.add(new Restaurant(2, "Tim Hortons", "1400 Collage Square, Ottawa, ON", "+1 (613) 255-1111"));

        // constructs a number of dishes
        dishes = new ArrayList<>();
        dishes.add(new Dish(1, "Egg McMuffin", "It's way healthy than you thought", R.mipmap.eggmcmuffin, "Egg", restaurants.get(0)));
        dishes.add(new Dish(2, "Peanut Butter Cookie", "Eat healthy eat fresh", R.mipmap.timcookies, "Peanut", restaurants.get(1)));
        dishes.add(new Dish(3, "Filet-O-Fish", "Nothing could be better", R.mipmap.filetofish, "Fish", restaurants.get(0)));
    }

    public static boolean login(String userid, String password) {
        for (User u : users)
            if (u.email == userid && u.password == password)
                return true;
        return false;
    }

    public static List<Dish> search(String query, String exclude) {
        return dishes;
    }

    public static Dish detail(int id) {
        for (Dish d : dishes)
            if (d.id == id)
                return d;
        return null;
    }
}

//:)~
