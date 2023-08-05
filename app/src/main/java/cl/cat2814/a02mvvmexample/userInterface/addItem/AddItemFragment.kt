package cl.cat2814.a02mvvmexample.userInterface.addItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cl.cat2814.a02mvvmexample.R
import cl.cat2814.a02mvvmexample.databinding.FragmentAddItemBinding
import cl.cat2814.a02mvvmexample.userInterface.ItemViewModel

class AddItemFragment : Fragment() {

    lateinit var binding: FragmentAddItemBinding

    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddItemBinding.inflate(layoutInflater, container, false)

        initListener()

        showTotalSum()

        return binding.root
    }

    private fun showTotalSum() {
        viewModel.getAllItems().observe(viewLifecycleOwner) { item ->
            binding.tvTotalSum.text = viewModel.calculateTotal(item)
        }
    }

    private fun initListener() {
        binding.btAddItem.setOnClickListener {
            val name = binding.etItemName.text.toString()
            val price = binding.etItemPrice.text.toString().toInt()
            val quantity = binding.etItemQuantity.text.toString().toInt()

            viewModel.insertItem(name, price, quantity)

            Toast.makeText(requireContext(), "Registro exitoso", Toast.LENGTH_LONG).show()

            cleanForm()
        }

        binding.btShowList.setOnClickListener {
            findNavController().navigate(R.id.action_addItemFragment_to_listItemFragment)
        }
    }

    private fun cleanForm() {
        binding.etItemName.setText("")
        binding.etItemPrice.setText("")
        binding.etItemQuantity.setText("")
    }
}
