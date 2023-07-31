package cl.cat2814.a02mvvmexample.userInterface.addItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.cat2814.a02mvvmexample.R
import cl.cat2814.a02mvvmexample.databinding.FragmentAddItemBinding

class AddItemFragment : Fragment() {

lateinit var binding: FragmentAddItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddItemBinding.inflate(layoutInflater, container, false)


        return binding.root

    }
}