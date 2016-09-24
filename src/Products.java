/**
 * Created by NSPACE on 9/22/2016.
 */

public class Products {
    private String title;
    private String product_type;
    private Variants[] variants;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("title: " + title + "\nproduct_type: " + product_type + "\nvariants: " + "\n");
        for(Variants variant : variants) {
            sb.append(" " + variant.toString() + "\n\n");
        }
        return sb.toString();
    }

    public String getProduct_type() {
        return product_type;
    }

    public Variants[] getVariants() {
        return variants;
    }
}
