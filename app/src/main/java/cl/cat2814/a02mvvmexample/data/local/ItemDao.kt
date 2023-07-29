package cl.cat2814.a02mvvmexample.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Insert
    suspend fun insertItem(item: ItemEntity)

    @Query("SELECT * FROM item_table ORDER BY id ASC")
    fun getAllItems(): LiveData<List<ItemEntity>>
}