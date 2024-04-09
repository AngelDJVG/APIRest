package com.appsmoviles.restapi.data

import com.appsmoviles.restapi.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

/**
 * @author
 */
class ProductsRepositoryImpl(
    private val api: Api
): ProductsRepository {

    override suspend fun getProductsList(): Flow<Result<List<Product>>> {
        return flow {
            try {
                val productsFromApi = api.getProductsList()
                emit(Result.Success(productsFromApi.products))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products", data = emptyList()))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products", data = emptyList()))
            }  catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products", data = emptyList()))
            }
        }
    }

}