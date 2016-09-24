import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by NSPACE on 9/22/2016.
 */

public interface ShopicruitService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://shopicruit.myshopify.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("products.json?page=num")
    Call<ProductsResponse> fetchProducts(@Query("page") int page);
}
