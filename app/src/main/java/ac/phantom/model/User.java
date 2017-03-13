package ac.phantom.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ron on 2/5/17.
 */

public class User {
    public int id;
    public String email;
    public String password;
    public List<Restriction> restrictions;

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.restrictions = new ArrayList<>();
    }
}

//:)~
