package ac.phantom;

import java.util.ArrayList;
import java.util.List;

import ac.phantom.model.Restriction;
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
    private static List<Restriction> restrictions = null;    // dietary restriction list (table)

    static {
        // dietary restrictions
        restrictions = new ArrayList<>();
        restrictions.add(new Restriction(1, "Egg"));
        restrictions.add(new Restriction(2, "Peanut"));
        restrictions.add(new Restriction(3, "Fish"));

        // constructs a couple of users
        users = new ArrayList<>();
        users.add(new User(1, "alice@ac.com", "123456"));
        users.add(new User(2, "bob@ac.com", "654321"));
        for (int i = 0; i < users.size(); ++i)
            users.get(i).restrictions.add(restrictions.get(i % restrictions.size()));

        // creates a few restaurants
        restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1, "McDonald's", "1850 Baseline Rd, Nepean, ON K2L 0C6", "+1 (613) 255-0000"));
        restaurants.add(new Restaurant(2, "Tim Hortons", "4060 Carling Ave, Kanata, ON K2K 1Y1", "+1 (613) 255-1111"));

        // constructs a number of dishes
        dishes = new ArrayList<>();
        dishes.add(new Dish(1, "Egg McMuffin", "It's way healthy than you thought", R.mipmap.eggmcmuffin, restaurants.get(0)));
        dishes.add(new Dish(2, "Peanut Butter Cookie", "Eat healthy eat fresh", R.mipmap.timcookies, restaurants.get(1)));
        dishes.add(new Dish(3, "Filet O Fish", "Nothing could be better", R.mipmap.filetofish, restaurants.get(0)));
        for (int i = 0; i < dishes.size(); ++i)
            dishes.get(i).restrictions.add(restrictions.get(i % restrictions.size()));
    }

    // where x and y are not null
    private static boolean find(Object x, Object y) {
        for (String e : x.toString().split(" "))
            if (y.toString().toLowerCase().contains(e.toLowerCase()))
                return true;
        return false;
    }

    public static User login(String userid, String password) {
        for (User u : users)
            if (u.email == userid && u.password == password)
                return u;
        return null;
    }

    public static List<Restriction> getRestrictions() { return restrictions; }

    public static List<Dish> search(String query, String exclude) {
        String q = query != null ? query : "";
        String x = exclude != null && !exclude.equals("") ? exclude : "\b";
        List<Dish> sub = new ArrayList<>();
        for (Dish d : dishes)
            if (!find(x, d.restrictions) && find(q, d))
                sub.add(d);
        return sub;
    }

    public static Dish detail(int id) {
        for (Dish d : dishes)
            if (d.id == id)
                return d;
        return null;
    }
}

//:)~
