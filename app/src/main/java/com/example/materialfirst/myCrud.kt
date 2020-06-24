package com.example.materialfirst

import android.app.Person
import com.orm.SugarRecord

class myCrud {


    public fun AddRecord(name:String, phoneNumber:String)
    {
        if(name!=null)
        {
            val person = PersonModel()
            person.name = name
            person.phonenumber = phoneNumber
            person.save()
        }
    }
    public fun GetAllRecords():List<PersonModel> {
        return SugarRecord.listAll(PersonModel::class.java)
    }
}