package com.example.bottom.fragmentsgenre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.bottom.R
import org.w3c.dom.Text

class action : Fragment() {

    lateinit var d : TextView

    var displayMessage : String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_action, container, false)


        d = v.findViewById(R.id.display)


        displayMessage = arguments?.getString("message")

        d.text = displayMessage

        return v

    }


}