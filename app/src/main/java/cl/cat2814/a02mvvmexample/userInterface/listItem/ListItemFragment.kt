package cl.cat2814.a02mvvmexample.userInterface.listItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cl.cat2814.a02mvvmexample.R
import cl.cat2814.a02mvvmexample.databinding.FragmentListItemBinding
import cl.cat2814.a02mvvmexample.userInterface.ItemViewModel

class ListItemFragment : Fragment() {

    private lateinit var binding: FragmentListItemBinding

    private val viewModel: ItemViewModel by activityViewModels()

    private val adapter = ItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListItemBinding.inflate(inflater, container, false)

        initRecyclerView()
        loadData()
        initListener()

        return binding.root
    }

    private fun initListener() {
        binding.addItem.setOnClickListener {
            findNavController().navigate(R.id.action_listItemFragment_to_addItemFragment)
        }
    }

    private fun loadData() {
        viewModel.getAllItems().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        binding.listItems.adapter = adapter
    }
}
