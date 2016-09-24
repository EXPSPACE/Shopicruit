import retrofit2.Call;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by NSPACE on 9/24/2016.
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Products> productList = new ArrayList<>();
        ProductsResponse productsResponse;
        int pageNum = 1;

        //perform get requests for products from shopicruit rest api
        try {
            do {
                ShopicruitService shopicruitService = ShopicruitService.retrofit.create(ShopicruitService.class);
                Call<ProductsResponse> call = shopicruitService.fetchProducts(pageNum);
                productsResponse = call.execute().body();
                productList.addAll(Arrays.asList(productsResponse.getProducts()));
                pageNum++;
            } while(productsResponse.getProducts().length > 0);

        } catch (IOException e) {
            e.printStackTrace();
        }

        printClockWatchTotal(productList);
    }

    //computes total price of all clock and watch products that are available
    private static void printClockWatchTotal(ArrayList<Products> productList) {
        BigDecimal totalPrice = new BigDecimal(0);

        for(Products product : productList) {
            if(product.getProduct_type().equals("Clock") || product.getProduct_type().equals("Watch")) {
                Variants[] variantList = product.getVariants();
                for(Variants variant : variantList) {
                    if(variant.isAvailable()) {
                        System.out.println(product.toString());
                        totalPrice = totalPrice.add(new BigDecimal(variant.getPrice()));
                    }
                }
            }
        }
        System.out.println("total price:  " + totalPrice.toPlainString());
    }
}
