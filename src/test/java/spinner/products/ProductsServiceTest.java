package spinner.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsServiceTest
{

    @Test
    void getProducts()
    {
        //given
        ProductsService service = new ProductsServiceFactory().create();

        //when
        ProductsResponse products = service.getProducts()
                .blockingGet();
        //downloads the list of products

        /* We want this to block.
                Without .blockingGet this doesn't work because the interface returns a single
            What is blocking?
        * want it to wait until data is downloaded and data is in test */

        //then
        assertEquals(30, products.products.length);
        //json reposnse was parsed into 30 objects
        //can verify
        //assertTrue(products.products.length > 0); if you don't know how many objects this is what you can use
    }
}