package com.example.shoppinglist.persistence

import com.example.shoppinglist.Utility.MockTestUtil.mockProductList
import com.example.shoppinglist.model.Product
import com.example.shoppinglist.network.LocalDatabase
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class PosterDaoTest : LocalDatabase() {

    private lateinit var productDao: ProductDao

    @Before
    fun init() {
        productDao = db.productDao()
    }

    @Test
    fun insertAndLoadPosterListTest() = runBlocking {
        val mockDataList = mockProductList()
        productDao.insertProductList(mockDataList)

        val loadFromDB = productDao.getProductList()
        MatcherAssert.assertThat(loadFromDB.toString(), `is`(mockDataList.toString()))

        val mockData = Product.mock()
        MatcherAssert.assertThat(loadFromDB[0].toString(), `is`(mockData.toString()))
    }
}