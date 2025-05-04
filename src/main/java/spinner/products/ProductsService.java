package spinner.products;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ProductsService {
    //requests the json
    //use to request data from the internet


    @GET("/products")
    Single<ProductsResponse> getProducts();

    /* Describes how we get the data
    gets data from the website
    call get products
    returns a single
    */


}
