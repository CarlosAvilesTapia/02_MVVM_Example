package cl.cat2814.a02mvvmexample.userInterface

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.cat2814.a02mvvmexample.data.ItemRepository
import cl.cat2814.a02mvvmexample.data.local.ItemDatabase
import cl.cat2814.a02mvvmexample.data.local.ItemEntity
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    private val itemRepository: ItemRepository

    init {
        val dao = ItemDatabase.getDatabase(application).getItemsDao()
        itemRepository = ItemRepository(dao)
    }

    fun getAllItems(): LiveData<List<ItemEntity>> = itemRepository.getAllItems()

    fun insertItem(name: String, price: Int, quantity: Int) = viewModelScope.launch {
        val item = ItemEntity(name, price, quantity)
        itemRepository.insertItem(item)
    }
}