package com.example.contactappfragment

interface ItemClickListener {
    fun ItemClicked(item: Information)

    fun ButtonClicked(btn_name: String)

    fun SubmitClicked(item: Information)
}