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

    public final static String EXTRA_RESTRICT = "r";
    public final static String EXTRA_QUERY = "q";
    public final static String EXTRA_DISH = "d";
    public final static String EXTRA_ADDR = "a";

    static {
        // dietary restrictions
        restrictions = new ArrayList<>();
        restrictions.add(new Restriction(1, "Egg"));
        restrictions.add(new Restriction(2, "Peanut"));
        restrictions.add(new Restriction(3, "Fish"));

        // constructs a couple of users
        users = new ArrayList<>();
        users.add(new User(1, "alice", "123456"));
        users.add(new User(2, "bob", "654321"));
        for (int i = 0; i < users.size(); ++i)
            users.get(i).restrictions.add(restrictions.get(i % restrictions.size()));

        // creates a few restaurants
        restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1, "McDonald's", "1850 Baseline Rd, Nepean, ON K2L 0C6", "+1 (613) 255-0000"));
        restaurants.add(new Restaurant(2, "Tim Hortons", "4060 Carling Ave, Kanata, ON K2K 1Y1", "+1 (613) 255-1111"));
        restaurants.add(new Restaurant(2, "Pizza Pizza", "673 Somerset St W, Ottawa, ON K1R 6P3", "+1 (613) 737-1111"));

        // constructs a number of dishes
        dishes = new ArrayList<>();
        dishes.add(new Dish(6, "National Pride", "Topped with classic pepperoni, fresh mushrooms, bacon crumble and mozzarella cheese. Made by a proudly Canadian company.\n\n Tip: Try with cheddar jalapeno dipping sauce.", R.mipmap.pizza, restaurants.get(2)));
        dishes.add(new Dish(1, "Egg McMuffin", "It's way healthy than you thought", R.mipmap.eggmcmuffin, restaurants.get(0)));
        dishes.add(new Dish(9, "Triple Thick Milkshake®", "Thick, smooth and deliciously creamy soft serve, mixed with your choice of decadent chocolate, strawberry or vanilla syrup for an extra taste of yumminess.", R.mipmap.mcdrink, restaurants.get(0)));
        dishes.add(new Dish(5, "Chicken with Attitude", "Topped with chipotle chicken, red onions, chipotle BBQ sauce and mozzarella cheese.", R.mipmap.pizza, restaurants.get(2)));
        dishes.add(new Dish(2, "Peanut Butter Cookie", "Eat healthy eat fresh", R.mipmap.timcookies, restaurants.get(1)));
        dishes.add(new Dish(3, "Filet O Fish", "Nothing could be better", R.mipmap.filetofish, restaurants.get(0)));
        dishes.add(new Dish(4, "Hot & Spicy Chicken", "Made with our Buffalo blue cheese sauce, grilled chicken, red onions, fire roasted red peppers & mozzarella cheese.", R.mipmap.pizza, restaurants.get(2)));
        dishes.add(new Dish(8, "McFlurry®", "Deliciousness starts with creamy vanilla soft serve swirled together with your favourite mix-ins. Choose your McFlurry® treat, from SKOR® to Oreo® to M&M’s® candies and enjoy the yummy taste.", R.mipmap.mcdrink, restaurants.get(0)));
        dishes.add(new Dish(7, "Sweet Heat", "Mesquite chicken, pineapple, hot banana peppers and mozzarella cheese", R.mipmap.pizza, restaurants.get(2)));
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
            if (u.email.equals(userid) && u.password.equals(password))
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
