package com.example.shoppinglist.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoppinglist.model.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductList(posters: List<Product>)

    @Query("SELECT * FROM Product WHERE id = :id_")
    suspend fun getProduct(id_: String): Product?

    @Query("SELECT * FROM Product")
    suspend fun getProductList(): List<Product>
}