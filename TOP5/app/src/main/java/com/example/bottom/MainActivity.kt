package com.example.bottom

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottom.fragments.Gamesmenu
import com.example.bottom.fragments.Moviesmenu
import com.example.bottom.fragments.Musicmenu
import com.example.bottom.fragments.Top5menu
import com.example.bottom.fragmentsgenre.action
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(),Com {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val top5fragment = Top5menu()
        val moviesfragement = Moviesmenu()
        val musicfragment = Musicmenu()
        val gamesfragment = Gamesmenu()


        makeCurrentFragment(top5fragment)


        val bn = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bn.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.top5main-> {
                    Log.wtf("MainActivity","hello")
                    makeCurrentFragment(top5fragment)
                }
                R.id.moviesmain-> {
                    makeCurrentFragment(moviesfragement)
                }
                R.id.gamesmain-> {
                    makeCurrentFragment(gamesfragment)
                }
                R.id.musicmain-> {
                    makeCurrentFragment(musicfragment)
                }
            }
            true

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }


    private fun makeCurrentFragment(fragment: Fragment)= supportFragmentManager.beginTransaction().apply {
        replace(R.id.frame1,fragment,fragment.javaClass.simpleName)
        commit()
    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("message", editTextInput)

        val t = this.supportFragmentManager.beginTransaction()
        val action = action()
        action.arguments = bundle

        t.replace(R.id.frame1,action)
        t.commit()
    }
}