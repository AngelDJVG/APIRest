package com.appsmoviles.restapi.data

import com.appsmoviles.restapi.data.model.Product
import kotlinx.coroutines.flow.Flow

/**
 * @author
 */
interface ProductsRepository {
    suspend fun getProductsList(): Flow<Result<List<Product>>>
}