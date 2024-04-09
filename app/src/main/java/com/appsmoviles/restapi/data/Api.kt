package com.appsmoviles.restapi.data
import com.appsmoviles.restapi.data.model.Products
import retrofit2.http.GET

/**
 * @author
 */
interface Api {

    @GET("products")
    suspend fun getProductsList(): Products

    companion object {
        const val BASE_URL = "https://dummyjson.com"
    }

}