package cl.cat2814.a02mvvmexample.userInterface

import android.app.Application
import android.icu.text.NumberFormat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.cat2814.a02mvvmexample.data.ItemRepository
import cl.cat2814.a02mvvmexample.data.local.ItemDatabase
import cl.cat2814.a02mvvmexample.data.local.ItemEntity
import kotlinx.coroutines.launch
import java.util.Locale

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

    fun calculateTotal(item: List<ItemEntity>): String {
        var total = 0
        for (items in item) {
            total += items.price * items.quantity
        }
        return getPriceFormat(total)
    }

    fun getPriceFormat(price: Int): String {
        val currency: NumberFormat = NumberFormat.getCurrencyInstance(Locale("es", "CL"))
        return currency.format(price)
    }
}