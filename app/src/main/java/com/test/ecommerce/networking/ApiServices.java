package com.test.ecommerce.networking;

import com.test.ecommerce.model.RootModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("product-details?product_id=1812&lang=en&store=KW")
    Observable<RootModel> getProductDetails();
}
