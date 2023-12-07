package com.example.contactappfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.contactappfragment.R

class AddItemFragment : Fragment() {

    lateinit var nameInp: TextView
    lateinit var phoneInp: TextView
    lateinit var emailInp: TextView
    lateinit var submitBtn: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameInp = view.findViewById(R.id.name_input)
        phoneInp = view.findViewById(R.id.phone_input)
        emailInp = view.findViewById(R.id.email_input)
        submitBtn = view.findViewById(R.id.submit_button)

        submitBtn.setOnClickListener {
            if (activity is ItemClickListener)
                (activity as ItemClickListener)
                    .SubmitClicked(Information("ID", nameInp.text.toString(), phoneInp.text.toString(), emailInp.text.toString()))
        }
    }
}