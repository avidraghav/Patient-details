package com.example.medicalhistory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_home.*


class Homefragment : Fragment() {
    private val currentUser = FirebaseAuth.getInstance().currentUser

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        form_open_button.setOnClickListener {
            context?.form()
        }
    }



//    override fun onStart() {
//        super.onStart()
//        mAuth.currentUser?.let {
//            context?.form()
//        }
//    }
}
