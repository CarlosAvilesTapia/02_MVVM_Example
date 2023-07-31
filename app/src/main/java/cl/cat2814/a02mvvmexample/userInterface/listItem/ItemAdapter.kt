package cl.cat2814.a02mvvmexample.userInterface.listItem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.cat2814.a02mvvmexample.data.local.ItemEntity
import cl.cat2814.a02mvvmexample.databinding.ItemBinding

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    private var items: List<ItemEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class ItemViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemEntity) {
            binding.tvItemName.text = item.name
            binding.tvItemPrice.text = item.price.toString()
            binding.tvItemQuantity.text = item.quantity.toString()
            binding.tvItemTotal.text = (item.price * item.quantity).toString()
        }
    }
}