package com.example.contactappfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListFragment: Fragment() {
    lateinit var listView: ListView
    lateinit var items: ArrayList<Information>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = view.findViewById(R.id.list_view)

        items = arrayListOf(
            Information("1", "John Doe", "+1234567890", "johndoe@example.com"),
            Information("2", "Jane Smith", "+0987654321", "janesmith@example.com"),
            Information("3", "Bob Johnson", "+1122334455", "bobjohnson@example.com"),
            Information("4", "Alice Williams", "+5566778899", "alicewilliams@example.com"),
            Information("5", "Charlie Brown", "+9988776655", "charliebrown@example.com")
        )

        listView.adapter = ListViewAdapter(requireContext(), items)

        listView.setOnItemClickListener { parent, view, position, id ->
            val item = items[position]
            if (activity is ItemClickListener)
                (activity as ItemClickListener).ItemClicked(item)
        }
    }

    fun AddItem(item: Information){
        var id = items.size
        item.id = "ID$id"
        items.add(item)
    }
}
