package com.example.backnavigationtestapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class FragmentA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drawerLayout = activity?.findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        val appBarConfig = AppBarConfiguration(findNavController().graph, drawerLayout)

        NavigationUI.setupWithNavController(toolbar, findNavController(), appBarConfig)

        val button1 = view.findViewById<Button>(R.id.button_a1)
        button1.setOnClickListener {
            val action = FragmentADirections.actionFragmentAToFragmentB()
            findNavController().navigate(action)
        }

        val button2 = view.findViewById<Button>(R.id.button_a2)
        button2.setOnClickListener {
            drawerLayout?.openDrawer(GravityCompat.START)
        }

        val drawerNavView = activity?.findViewById<NavigationView>(R.id.drawer_navigation_view)
        drawerNavView?.setNavigationItemSelectedListener { _ ->
            val action = FragmentADirections.actionFragmentAToFragmentC()
            findNavController().navigate(action)

            drawerLayout?.closeDrawer(GravityCompat.START)
            true
        }
    }
}
