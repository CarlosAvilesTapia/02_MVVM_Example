package cl.cat2814.a02mvvmexample.data

import androidx.lifecycle.LiveData
import cl.cat2814.a02mvvmexample.data.local.ItemDao
import cl.cat2814.a02mvvmexample.data.local.ItemEntity

class ItemRepository(private val itemDao: ItemDao) {
    suspend fun insertItem(itemEntity: ItemEntity) {
        itemDao.insertItem(itemEntity)
    }

    fun getItems(): LiveData<List<ItemEntity>> {
        return itemDao.getAllItems()
    }
}