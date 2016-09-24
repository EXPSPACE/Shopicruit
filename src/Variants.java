/**
 * Created by NSPACE on 9/22/2016.
 */

public class Variants {
    private String title;
    private boolean available;
    private String price;

    @Override
    public String toString() {
        return "title: " + title + "\n available: " + available + "\n price: " + price;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getPrice() {
        return price;
    }
}
