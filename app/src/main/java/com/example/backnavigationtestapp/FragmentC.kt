package com.example.backnavigationtestapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FragmentC : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button1 = view.findViewById<Button>(R.id.button_c1)
        button1.setOnClickListener {
            val action = FragmentCDirections.actionFragmentCToFragmentD()
            findNavController().navigate(action)
        }

        val button2 = view.findViewById<Button>(R.id.button_c2)
        button2.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
