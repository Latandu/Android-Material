package com.example.materialfirst

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.orm.SugarRecord
import kotlinx.android.synthetic.main.fragment_add_contact.*
import kotlinx.android.synthetic.main.fragment_add_contact.view.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*


class AddContactFragment : Fragment() {
    lateinit var mView: View


    val MyCrud = myCrud()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_add_contact, container, false)

      mView.btnAdd.setOnClickListener()
      {
          MyCrud.AddRecord(txtName.text.toString(), txtPhone.text.toString())
          Toast.makeText(mView.context, "contact added", Toast.LENGTH_SHORT).show()
      }
        return mView
    }




}