package ac.phantom.model;

/**
 * Created by ron on 2/5/17.
 */

public class Restaurant {
    public int id;
    public String name;
    public String address;
    public String phone;

    public Restaurant(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.name, this.address, this.phone);
    }
}

//:)~
