package ac.phantom.model;

/**
 * Created by ron on 3/13/17.
 */

public class Restriction {
    public int id;
    public String label;

    public Restriction(int id, String label) {
        this.id = id;
        this.label = label;
    }

    @Override
    public String toString() {
        return String.format("%s", this.label);
    }
}

//:)~
