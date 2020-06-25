package com.example.materialfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.orm.SchemaGenerator
import com.orm.SugarContext
import com.orm.SugarDb
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        val drawerToggle = ActionBarDrawerToggle(this,drawer,0,0)
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        SugarContext.init(this)
        val schemaGenerator=SchemaGenerator(this)
        schemaGenerator.createDatabase(SugarDb(this).db)

        setFragment("main")

        setupDrawerContent(navigationView)

        var myFragment = MainFragment()

     /*   val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, myFragment)
        transaction.addToBackStack(null)
        transaction.commit() */


    }
    private fun setFragment(fragmentName: String)
    {
        lateinit var myFragment:Fragment
        when(fragmentName)
        {
            "main"->
            {
                myFragment = MainFragment()
            }
            "add"->
            {
                myFragment = AddContactFragment()
            }
            "del"->
            {
                myFragment = DelContactFragment()
            }
            "update"->
            {
                myFragment = UpdateContactFragment()
            }
        }
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, myFragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    private fun setupDrawerContent(navigationView: NavigationView)
    {
        navigationView.setNavigationItemSelectedListener()
        {
            menuItem ->  when(menuItem.itemId)
             {
                R.id.showContacts->
                {
                    setFragment("main")

                }
                R.id.addContact->
                {
                    setFragment("add")


                }
                R.id.delContact->
                {
                    setFragment("del")
                }
                R.id.updateContact->
                {
                    setFragment("update")
                }
             }
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
      return when(item.itemId)
      {
          android.R.id.home->
          {
              drawer.openDrawer(GravityCompat.START)
              true
          }
          else -> super.onOptionsItemSelected(item)
      }
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START)
        }
        else super.onBackPressed()
    }
    }