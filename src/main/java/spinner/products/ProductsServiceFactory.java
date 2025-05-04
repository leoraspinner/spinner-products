package spinner.products;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsServiceFactory {


    public ProductsService create() {
        // configure Retrofit for the dummyjson website
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")      //the server connecting to
                // Configure Retrofit to use Gson to turn the Json into Objects
                .addConverterFactory(GsonConverterFactory.create())
                // Configure Retrofit to use Rx
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        //given all these, create a product
        ProductsService service = retrofit.create(ProductsService.class);
        return service;
    }

}
