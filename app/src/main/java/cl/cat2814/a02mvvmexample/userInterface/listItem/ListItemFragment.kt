package cl.cat2814.a02mvvmexample.userInterface.listItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.cat2814.a02mvvmexample.R
import cl.cat2814.a02mvvmexample.databinding.FragmentListItemBinding


class ListItemFragment : Fragment() {

    private lateinit var binding: FragmentListItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_item, container, false)
    }
}