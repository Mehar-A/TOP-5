package com.example.bottom.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.bottom.Com
import com.example.bottom.R
import com.example.bottom.fragmentsgenre.*
import com.google.android.material.navigation.NavigationView


class Moviesmenu : Fragment() {

    private lateinit var toolbar : androidx.appcompat.widget.Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var naview : NavigationView
    lateinit var image : ImageView
    lateinit var com : Com
    lateinit var ac : Fragment

    lateinit var AA : String
    lateinit var BB : String
    lateinit var EE : String
    lateinit var FF : String
    lateinit var GG : String
    lateinit var SS : String


    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("dontgiveatwofucks", "hello")
        if(toggle.onOptionsItemSelected(item)){
            drawerLayout.openDrawer(GravityCompat.START)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    @Override
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_moviesmenu, container, false)

        /*
        toolbar = v.findViewById(R.id.tb)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
         */

        image = v.findViewById(R.id.imageM)
        image.setOnClickListener{
            drawerLayout.openDrawer(GravityCompat.START)
        }

        drawerLayout = v.findViewById(R.id.drawerL) //Note this line
        
        toggle = ActionBarDrawerToggle(activity, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        naview = v.findViewById(R.id.nav_view)
        drawerLayout.openDrawer(GravityCompat.START)

        ac = action()

        AA = "Avengeres"
        BB = "Men in Black"
        EE = "Ford Vs Ferrari"
        FF = "The Nun"
        GG = "Intersellar"
        SS = "Rome and Juilet"

        com = activity as Com


        naview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.aa -> {
                    com.passDataCom(AA.toString())
                }
                R.id.c -> {
                    com.passDataCom(BB.toString())
                }
                R.id.d -> {
                    com.passDataCom(EE.toString())
                }
                R.id.h -> {
                    com.passDataCom(FF.toString())
                }
                R.id.sf -> {
                    com.passDataCom(GG.toString())
                }
                R.id.r -> {
                    com.passDataCom(SS.toString())
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        return v


    }





}