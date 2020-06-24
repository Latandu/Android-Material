package com.example.materialfirst

import android.app.Person
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*


class MainFragment : Fragment() {
    lateinit var mView: View

    lateinit var contactsList: List<PersonModel>

    val MyCrud = myCrud()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        mView = inflater.inflate(R.layout.fragment_main, container, false)

        mView.btnPress.setOnClickListener()
        {
            contactsList = MyCrud.GetAllRecords() as ArrayList

            lblResult.text = contactsList.size.toString()
        }
        return mView
    }

}